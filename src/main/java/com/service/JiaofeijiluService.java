package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiaofeijiluEntity;
import java.util.Map;

/**
 * 缴费记录 服务类
 * @author 
 * @since 2021-03-31
 */
public interface JiaofeijiluService extends IService<JiaofeijiluEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);

}