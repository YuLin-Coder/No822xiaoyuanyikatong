package com.dao;

import com.entity.JiaofeileixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaofeileixingView;

/**
 * 缴费类型 Dao 接口
 *
 * @author 
 * @since 2021-03-31
 */
public interface JiaofeileixingDao extends BaseMapper<JiaofeileixingEntity> {

   List<JiaofeileixingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
