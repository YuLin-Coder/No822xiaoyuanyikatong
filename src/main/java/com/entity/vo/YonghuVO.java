package com.entity.vo;

import com.entity.YonghuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 用户表
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-31
 */
@TableName("yonghu")
public class YonghuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 名称
     */

    @TableField(value = "name")
    private String name;


    /**
     * 账号
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 头像
     */

    @TableField(value = "img_photo")
    private String imgPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 手机号
     */

    @TableField(value = "phone")
    private String phone;


    /**
     * 身份证
     */

    @TableField(value = "id_number")
    private String idNumber;


    /**
     * 余额
     */

    @TableField(value = "balance")
    private Double balance;


    /**
     * 身份
     */

    @TableField(value = "role")
    private String role;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：名称
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：名称
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：账号
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账号
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：头像
	 */
    public String getImgPhoto() {
        return imgPhoto;
    }


    /**
	 * 获取：头像
	 */

    public void setImgPhoto(String imgPhoto) {
        this.imgPhoto = imgPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：手机号
	 */
    public String getPhone() {
        return phone;
    }


    /**
	 * 获取：手机号
	 */

    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
	 * 设置：身份证
	 */
    public String getIdNumber() {
        return idNumber;
    }


    /**
	 * 获取：身份证
	 */

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
    /**
	 * 设置：余额
	 */
    public Double getBalance() {
        return balance;
    }


    /**
	 * 获取：余额
	 */

    public void setBalance(Double balance) {
        this.balance = balance;
    }
    /**
	 * 设置：身份
	 */
    public String getRole() {
        return role;
    }


    /**
	 * 获取：身份
	 */

    public void setRole(String role) {
        this.role = role;
    }

}
