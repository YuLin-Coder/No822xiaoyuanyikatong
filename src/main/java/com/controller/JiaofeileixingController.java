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

import com.entity.JiaofeileixingEntity;

import com.service.JiaofeileixingService;
import com.entity.view.JiaofeileixingView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 缴费类型
 * 后端接口
 * @author
 * @email
 * @date 2021-03-31
*/
@RestController
@Controller
@RequestMapping("/jiaofeileixing")
public class JiaofeileixingController {
    private static final Logger logger = LoggerFactory.getLogger(JiaofeileixingController.class);

    @Autowired
    private JiaofeileixingService jiaofeileixingService;


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
        PageUtils page = jiaofeileixingService.queryPage(params);

        //字典表数据转换
        List<JiaofeileixingView> list =(List<JiaofeileixingView>)page.getList();
        for(JiaofeileixingView c:list){
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
        JiaofeileixingEntity jiaofeileixing = jiaofeileixingService.selectById(id);
        if(jiaofeileixing !=null){
            //entity转view
            JiaofeileixingView view = new JiaofeileixingView();
            BeanUtils.copyProperties( jiaofeileixing , view );//把实体数据重构到view中

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
    public R save(@RequestBody JiaofeileixingEntity jiaofeileixing, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiaofeileixing:{}",this.getClass().getName(),jiaofeileixing.toString());
        Wrapper<JiaofeileixingEntity> queryWrapper = new EntityWrapper<JiaofeileixingEntity>()
            .eq("name", jiaofeileixing.getName())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaofeileixingEntity jiaofeileixingEntity = jiaofeileixingService.selectOne(queryWrapper);
        if(jiaofeileixingEntity==null){
            jiaofeileixing.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      jiaofeileixing.set
        //  }
            jiaofeileixingService.insert(jiaofeileixing);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiaofeileixingEntity jiaofeileixing, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jiaofeileixing:{}",this.getClass().getName(),jiaofeileixing.toString());
        //根据字段查询是否有相同数据
        Wrapper<JiaofeileixingEntity> queryWrapper = new EntityWrapper<JiaofeileixingEntity>()
            .notIn("id",jiaofeileixing.getId())
            .andNew()
            .eq("name", jiaofeileixing.getName())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaofeileixingEntity jiaofeileixingEntity = jiaofeileixingService.selectOne(queryWrapper);
        if(jiaofeileixingEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      jiaofeileixing.set
            //  }
            jiaofeileixingService.updateById(jiaofeileixing);//根据id更新
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
        jiaofeileixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

