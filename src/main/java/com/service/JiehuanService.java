package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiehuanEntity;
import java.util.Map;

/**
 * 设备借还 服务类
 * @author 
 * @since 2021-03-31
 */
public interface JiehuanService extends IService<JiehuanEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}