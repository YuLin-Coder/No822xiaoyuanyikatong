package com.dao;

import com.entity.JiaofeijiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaofeijiluView;

/**
 * 缴费记录 Dao 接口
 *
 * @author 
 * @since 2021-03-31
 */
public interface JiaofeijiluDao extends BaseMapper<JiaofeijiluEntity> {

   List<JiaofeijiluView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
