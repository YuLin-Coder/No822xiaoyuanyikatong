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

import com.entity.JiaofeijiluEntity;

import com.service.JiaofeijiluService;
import com.entity.view.JiaofeijiluView;
import com.service.YonghuService;
import com.entity.YonghuEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 缴费记录
 * 后端接口
 * @author
 * @email
 * @date 2021-03-31
*/
@RestController
@Controller
@RequestMapping("/jiaofeijilu")
public class JiaofeijiluController {
    private static final Logger logger = LoggerFactory.getLogger(JiaofeijiluController.class);

    @Autowired
    private JiaofeijiluService jiaofeijiluService;


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
        PageUtils page = jiaofeijiluService.queryPage(params);

        //字典表数据转换
        List<JiaofeijiluView> list =(List<JiaofeijiluView>)page.getList();
        for(JiaofeijiluView c:list){
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
        JiaofeijiluEntity jiaofeijilu = jiaofeijiluService.selectById(id);
        if(jiaofeijilu !=null){
            //entity转view
            JiaofeijiluView view = new JiaofeijiluView();
            BeanUtils.copyProperties( jiaofeijilu , view );//把实体数据重构到view中

            //级联表
            YonghuEntity yonghu = yonghuService.selectById(jiaofeijilu.getYonghuId());
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
    public R save(@RequestBody JiaofeijiluEntity jiaofeijilu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiaofeijilu:{}",this.getClass().getName(),jiaofeijilu.toString());
        Wrapper<JiaofeijiluEntity> queryWrapper = new EntityWrapper<JiaofeijiluEntity>()
            .eq("xfname", jiaofeijilu.getXfname())
            .eq("yonghu_id", jiaofeijilu.getYonghuId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaofeijiluEntity jiaofeijiluEntity = jiaofeijiluService.selectOne(queryWrapper);
        if(jiaofeijiluEntity==null){
            jiaofeijilu.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      jiaofeijilu.set
        //  }
            jiaofeijiluService.insert(jiaofeijilu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiaofeijiluEntity jiaofeijilu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jiaofeijilu:{}",this.getClass().getName(),jiaofeijilu.toString());
        //根据字段查询是否有相同数据
        Wrapper<JiaofeijiluEntity> queryWrapper = new EntityWrapper<JiaofeijiluEntity>()
            .notIn("id",jiaofeijilu.getId())
            .andNew()
            .eq("xfname", jiaofeijilu.getXfname())
            .eq("yonghu_id", jiaofeijilu.getYonghuId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaofeijiluEntity jiaofeijiluEntity = jiaofeijiluService.selectOne(queryWrapper);
                jiaofeijilu.setXiaofeiTime(new Date());
        if(jiaofeijiluEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      jiaofeijilu.set
            //  }
            jiaofeijiluService.updateById(jiaofeijilu);//根据id更新
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
        jiaofeijiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

