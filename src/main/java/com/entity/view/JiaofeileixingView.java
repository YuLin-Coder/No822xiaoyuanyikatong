package com.entity.view;

import com.entity.JiaofeileixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 缴费类型
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-31
 */
@TableName("jiaofeileixing")
public class JiaofeileixingView extends JiaofeileixingEntity implements Serializable {
    private static final long serialVersionUID = 1L;



	public JiaofeileixingView() {

	}

	public JiaofeileixingView(JiaofeileixingEntity jiaofeileixingEntity) {
		try {
			BeanUtils.copyProperties(this, jiaofeileixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}














}
