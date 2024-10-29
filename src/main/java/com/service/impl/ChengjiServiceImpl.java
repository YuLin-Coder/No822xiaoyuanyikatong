package com.service.impl;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.ChengjiDao;
import com.entity.ChengjiEntity;
import com.service.ChengjiService;
import com.entity.view.ChengjiView;

/**
 * 成绩 服务实现类
 * @author 
 * @since
 */
@Service("chengjiService")
@Transactional
public class ChengjiServiceImpl extends ServiceImpl<ChengjiDao, ChengjiEntity> implements ChengjiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ChengjiView> page =new Query<ChengjiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


    @Override
    public List<HashMap<String, Object>> groupBar() {
        return baseMapper.groupBar();
    }


}
