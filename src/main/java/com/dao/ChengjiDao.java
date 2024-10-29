package com.dao;

import com.entity.ChengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChengjiView;

/**
 * 成绩 Dao 接口
 *
 * @author 
 * @since
 */
public interface ChengjiDao extends BaseMapper<ChengjiEntity> {

   List<ChengjiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

   List<HashMap<String,Object>> groupBar();

}
