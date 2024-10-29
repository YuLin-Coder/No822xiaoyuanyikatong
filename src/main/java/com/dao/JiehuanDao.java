package com.dao;

import com.entity.JiehuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiehuanView;

/**
 * 设备借还 Dao 接口
 *
 * @author 
 * @since 2021-03-31
 */
public interface JiehuanDao extends BaseMapper<JiehuanEntity> {

   List<JiehuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
