package com.dao;

import com.entity.ShebeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShebeiView;

/**
 * 设备 Dao 接口
 *
 * @author 
 * @since 2021-03-31
 */
public interface ShebeiDao extends BaseMapper<ShebeiEntity> {

   List<ShebeiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
