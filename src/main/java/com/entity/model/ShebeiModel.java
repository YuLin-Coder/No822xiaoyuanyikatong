package com.entity.model;

import com.entity.ShebeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 设备
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-31
 */
public class ShebeiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


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
     * 设备信息
     */
    private String tongzhiContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：设备名称
	 */
    public String getSbname() {
        return sbname;
    }


    /**
	 * 设置：设备名称
	 */
    public void setSbname(String sbname) {
        this.sbname = sbname;
    }
    /**
	 * 获取：设备图片
	 */
    public String getSbimgPhoto() {
        return sbimgPhoto;
    }


    /**
	 * 设置：设备图片
	 */
    public void setSbimgPhoto(String sbimgPhoto) {
        this.sbimgPhoto = sbimgPhoto;
    }
    /**
	 * 获取：设备状态
	 */
    public Integer getShebeiTypes() {
        return shebeiTypes;
    }


    /**
	 * 设置：设备状态
	 */
    public void setShebeiTypes(Integer shebeiTypes) {
        this.shebeiTypes = shebeiTypes;
    }
    /**
	 * 获取：设备信息
	 */
    public String getTongzhiContent() {
        return tongzhiContent;
    }


    /**
	 * 设置：设备信息
	 */
    public void setTongzhiContent(String tongzhiContent) {
        this.tongzhiContent = tongzhiContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
