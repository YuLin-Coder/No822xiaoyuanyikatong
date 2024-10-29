package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.JiehuanEntity;
import com.entity.KaoqinEntity;
import com.service.JiehuanService;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.ShebeiEntity;

import com.service.ShebeiService;
import com.entity.view.ShebeiView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 设备
 * 后端接口
 * @author
 * @email
 * @date 2021-03-31
*/
@RestController
@Controller
@RequestMapping("/shebei")
public class ShebeiController {
    private static final Logger logger = LoggerFactory.getLogger(ShebeiController.class);

    @Autowired
    private ShebeiService shebeiService;

    @Autowired
    private JiehuanService jiehuanService;

    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        PageUtils page = shebeiService.queryPage(params);

        //字典表数据转换
        List<ShebeiView> list =(List<ShebeiView>)page.getList();
        for(ShebeiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShebeiEntity shebei = shebeiService.selectById(id);
        if(shebei !=null){
            //entity转view
            ShebeiView view = new ShebeiView();
            BeanUtils.copyProperties( shebei , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShebeiEntity shebei, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shebei:{}",this.getClass().getName(),shebei.toString());
        Wrapper<ShebeiEntity> queryWrapper = new EntityWrapper<ShebeiEntity>()
            .eq("sbname", shebei.getSbname())
            .eq("shebei_types", shebei.getShebeiTypes())
            .eq("tongzhi_content", shebei.getTongzhiContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShebeiEntity shebeiEntity = shebeiService.selectOne(queryWrapper);
        if(shebeiEntity==null){
            shebei.setCreateTime(new Date());
            shebei.setShebeiTypes(1);
            shebeiService.insert(shebei);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShebeiEntity shebei, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shebei:{}",this.getClass().getName(),shebei.toString());
        //根据字段查询是否有相同数据
        Wrapper<ShebeiEntity> queryWrapper = new EntityWrapper<ShebeiEntity>()
            .notIn("id",shebei.getId())
            .andNew()
            .eq("sbname", shebei.getSbname())
            .eq("shebei_types", shebei.getShebeiTypes())
            .eq("tongzhi_content", shebei.getTongzhiContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShebeiEntity shebeiEntity = shebeiService.selectOne(queryWrapper);
        if("".equals(shebei.getSbimgPhoto()) || "null".equals(shebei.getSbimgPhoto())){
                shebei.setSbimgPhoto(null);
        }
        if(shebeiEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      shebei.set
            //  }
            shebeiService.updateById(shebei);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
     * 申请
     */
    @RequestMapping("/shenqing")
    public R shenqing(Integer id, HttpServletRequest request){
        ShebeiEntity shebei = shebeiService.selectById(id);
        if(shebei == null){
            return R.error();
        }
        JiehuanEntity jiehuan = new JiehuanEntity();
        jiehuan.setCreateTime(new Date());
        jiehuan.setZhujieTime(new Date());
        jiehuan.setShebeiId(id);
        jiehuan.setYonghuId((Integer) request.getSession().getAttribute("userId"));
        jiehuan.setZhujieTypes(2);
        boolean insert = jiehuanService.insert(jiehuan);
        if(insert){
            shebei.setShebeiTypes(2);
            shebeiService.updateById(shebei);
            return R.ok();
        }else{
            return R.error();
        }
     }
    /**
     * 归还
     */
    @RequestMapping("/guihuan")
    public R guihuan(Integer id, HttpServletRequest request){
        JiehuanEntity jiehuan = jiehuanService.selectById(id);
        if(jiehuan == null){
            return R.error();
        }
        jiehuan.setGuihuanTime(new Date());
        jiehuan.setZhujieTypes(1);
        boolean b = jiehuanService.updateById(jiehuan);
        if(b){
            ShebeiEntity shebei = shebeiService.selectById(jiehuan.getShebeiId());
            if(shebei == null){
                return R.error();
            }
            shebei.setShebeiTypes(1);
            boolean b1 = shebeiService.updateById(shebei);
            if(b1){
                return R.ok();
            }
        }
        return R.error();
     }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        shebeiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

