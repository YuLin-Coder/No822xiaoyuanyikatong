package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.JiaofeijiluDao;
import com.entity.JiaofeijiluEntity;
import com.service.JiaofeijiluService;
import com.entity.view.JiaofeijiluView;

/**
 * 缴费记录 服务实现类
 * @author 
 * @since 2021-03-31
 */
@Service("jiaofeijiluService")
@Transactional
public class JiaofeijiluServiceImpl extends ServiceImpl<JiaofeijiluDao, JiaofeijiluEntity> implements JiaofeijiluService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<JiaofeijiluView> page =new Query<JiaofeijiluView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
