package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChengjiEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 成绩 服务类
 * @author 
 * @since
 */
public interface ChengjiService extends IService<ChengjiEntity> {

     PageUtils queryPage(Map<String, Object> params);
     List<HashMap<String,Object>> groupBar();
}