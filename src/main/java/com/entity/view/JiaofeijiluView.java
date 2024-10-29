package com.entity.view;

import com.entity.JiaofeijiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 缴费记录
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-31
 */
@TableName("jiaofeijilu")
public class JiaofeijiluView extends JiaofeijiluEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 yonghu
			/**
			* 名称
			*/
			private String name;
			/**
			* 账号
			*/
			private String username;
			/**
			* 密码
			*/
			private String password;
			/**
			* 头像
			*/
			private String imgPhoto;
			/**
			* 性别
			*/
			private Integer sexTypes;
				/**
				* 性别的值
				*/
				private String sexValue;
			/**
			* 手机号
			*/
			private String phone;
			/**
			* 身份证
			*/
			private String idNumber;
			/**
			* 身份
			*/
			private String role;

	public JiaofeijiluView() {

	}

	public JiaofeijiluView(JiaofeijiluEntity jiaofeijiluEntity) {
		try {
			BeanUtils.copyProperties(this, jiaofeijiluEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





















				//级联表的get和set yonghu
					/**
					* 获取： 名称
					*/
					public String getName() {
						return name;
					}
					/**
					* 设置： 名称
					*/
					public void setName(String name) {
						this.name = name;
					}
					/**
					* 获取： 账号
					*/
					public String getUsername() {
						return username;
					}
					/**
					* 设置： 账号
					*/
					public void setUsername(String username) {
						this.username = username;
					}
					/**
					* 获取： 密码
					*/
					public String getPassword() {
						return password;
					}
					/**
					* 设置： 密码
					*/
					public void setPassword(String password) {
						this.password = password;
					}
					/**
					* 获取： 头像
					*/
					public String getImgPhoto() {
						return imgPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setImgPhoto(String imgPhoto) {
						this.imgPhoto = imgPhoto;
					}
					/**
					* 获取： 性别
					*/
					public Integer getSexTypes() {
						return sexTypes;
					}
					/**
					* 设置： 性别
					*/
					public void setSexTypes(Integer sexTypes) {
						this.sexTypes = sexTypes;
					}


						/**
						* 获取： 性别的值
						*/
						public String getSexValue() {
							return sexValue;
						}
						/**
						* 设置： 性别的值
						*/
						public void setSexValue(String sexValue) {
							this.sexValue = sexValue;
						}
					/**
					* 获取： 手机号
					*/
					public String getPhone() {
						return phone;
					}
					/**
					* 设置： 手机号
					*/
					public void setPhone(String phone) {
						this.phone = phone;
					}
					/**
					* 获取： 身份证
					*/
					public String getIdNumber() {
						return idNumber;
					}
					/**
					* 设置： 身份证
					*/
					public void setIdNumber(String idNumber) {
						this.idNumber = idNumber;
					}
					/**
					* 获取： 身份
					*/
					public String getRole() {
						return role;
					}
					/**
					* 设置： 身份
					*/
					public void setRole(String role) {
						this.role = role;
					}


}
