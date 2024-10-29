package com.entity.view;

import com.entity.JiehuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 设备借还
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-31
 */
@TableName("jiehuan")
public class JiehuanView extends JiehuanEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 租借状态的值
		*/
		private String zhujieValue;



		//级联表 shebei
			/**
			* 设备名称
			*/
			private String sbname;
			/**
			* 设备图片
			*/
			private String sbimgPhoto;
			/**
			* 设备状态
			*/
			private Integer shebeiTypes;
				/**
				* 设备状态的值
				*/
				private String shebeiValue;
			/**
			* 设备信息
			*/
			private String tongzhiContent;

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

	public JiehuanView() {

	}

	public JiehuanView(JiehuanEntity jiehuanEntity) {
		try {
			BeanUtils.copyProperties(this, jiehuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 租借状态的值
			*/
			public String getZhujieValue() {
				return zhujieValue;
			}
			/**
			* 设置： 租借状态的值
			*/
			public void setZhujieValue(String zhujieValue) {
				this.zhujieValue = zhujieValue;
			}






















				//级联表的get和set shebei
					/**
					* 获取： 设备名称
					*/
					public String getSbname() {
						return sbname;
					}
					/**
					* 设置： 设备名称
					*/
					public void setSbname(String sbname) {
						this.sbname = sbname;
					}
					/**
					* 获取： 设备图片
					*/
					public String getSbimgPhoto() {
						return sbimgPhoto;
					}
					/**
					* 设置： 设备图片
					*/
					public void setSbimgPhoto(String sbimgPhoto) {
						this.sbimgPhoto = sbimgPhoto;
					}
					/**
					* 获取： 设备状态
					*/
					public Integer getShebeiTypes() {
						return shebeiTypes;
					}
					/**
					* 设置： 设备状态
					*/
					public void setShebeiTypes(Integer shebeiTypes) {
						this.shebeiTypes = shebeiTypes;
					}


						/**
						* 获取： 设备状态的值
						*/
						public String getShebeiValue() {
							return shebeiValue;
						}
						/**
						* 设置： 设备状态的值
						*/
						public void setShebeiValue(String shebeiValue) {
							this.shebeiValue = shebeiValue;
						}
					/**
					* 获取： 设备信息
					*/
					public String getTongzhiContent() {
						return tongzhiContent;
					}
					/**
					* 设置： 设备信息
					*/
					public void setTongzhiContent(String tongzhiContent) {
						this.tongzhiContent = tongzhiContent;
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
