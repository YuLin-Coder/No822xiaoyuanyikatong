package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
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

import com.entity.KaoqinEntity;

import com.service.KaoqinService;
import com.entity.view.KaoqinView;
import com.service.YonghuService;
import com.entity.YonghuEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 考勤
 * 后端接口
 * @author
 * @email
 * @date 2021-03-31
*/
@RestController
@Controller
@RequestMapping("/kaoqin")
public class KaoqinController {
    private static final Logger logger = LoggerFactory.getLogger(KaoqinController.class);

    @Autowired
    private KaoqinService kaoqinService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private YonghuService yonghuService;


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
        PageUtils page = kaoqinService.queryPage(params);
        //字典表数据转换
        List<KaoqinView> list =(List<KaoqinView>)page.getList();
        for(KaoqinView c:list){
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
        KaoqinEntity kaoqin = kaoqinService.selectById(id);
        if(kaoqin !=null){
            //entity转view
            KaoqinView view = new KaoqinView();
            BeanUtils.copyProperties( kaoqin , view );//把实体数据重构到view中

            //级联表
            YonghuEntity yonghu = yonghuService.selectById(kaoqin.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
            }
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
    public R save(@RequestBody KaoqinEntity kaoqin, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,kaoqin:{}",this.getClass().getName(),kaoqin.toString());
        kaoqin.setYonghuId((Integer)request.getSession().getAttribute("userId"));
        Wrapper<KaoqinEntity> queryWrapper = new EntityWrapper<KaoqinEntity>()
            .eq("qdname", kaoqin.getQdname())
            .eq("yonghu_id", kaoqin.getYonghuId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KaoqinEntity kaoqinEntity = kaoqinService.selectOne(queryWrapper);
        if(kaoqinEntity==null){
            kaoqin.setQiandaoTime(new Date());
            kaoqin.setCreateTime(new Date());
            kaoqinService.insert(kaoqin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KaoqinEntity kaoqin, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,kaoqin:{}",this.getClass().getName(),kaoqin.toString());
        //根据字段查询是否有相同数据
        Wrapper<KaoqinEntity> queryWrapper = new EntityWrapper<KaoqinEntity>()
            .notIn("id",kaoqin.getId())
            .andNew()
            .eq("qdname", kaoqin.getQdname())
            .eq("yonghu_id", kaoqin.getYonghuId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KaoqinEntity kaoqinEntity = kaoqinService.selectOne(queryWrapper);
                kaoqin.setQiandaoTime(new Date());
        if(kaoqinEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      kaoqin.set
            //  }
            kaoqinService.updateById(kaoqin);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        kaoqinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

