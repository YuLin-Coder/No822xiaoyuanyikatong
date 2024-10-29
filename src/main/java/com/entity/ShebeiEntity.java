package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 设备
 *
 * @author 
 * @email
 * @date 2021-03-31
 */
@TableName("shebei")
public class ShebeiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShebeiEntity() {

	}

	public ShebeiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 设备名称
     */
    @TableField(value = "sbname")

    private String sbname;


    /**
     * 设备图片
     */
    @TableField(value = "sbimg_photo")

    private String sbimgPhoto;


    /**
     * 设备状态
     */
    @TableField(value = "shebei_types")

    private Integer shebeiTypes;


    /**
     * 设备信息
     */
    @TableField(value = "tongzhi_content")

    private String tongzhiContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


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
	 * 设置：设备名称
	 */
    public String getSbname() {
        return sbname;
    }


    /**
	 * 获取：设备名称
	 */

    public void setSbname(String sbname) {
        this.sbname = sbname;
    }
    /**
	 * 设置：设备图片
	 */
    public String getSbimgPhoto() {
        return sbimgPhoto;
    }


    /**
	 * 获取：设备图片
	 */

    public void setSbimgPhoto(String sbimgPhoto) {
        this.sbimgPhoto = sbimgPhoto;
    }
    /**
	 * 设置：设备状态
	 */
    public Integer getShebeiTypes() {
        return shebeiTypes;
    }


    /**
	 * 获取：设备状态
	 */

    public void setShebeiTypes(Integer shebeiTypes) {
        this.shebeiTypes = shebeiTypes;
    }
    /**
	 * 设置：设备信息
	 */
    public String getTongzhiContent() {
        return tongzhiContent;
    }


    /**
	 * 获取：设备信息
	 */

    public void setTongzhiContent(String tongzhiContent) {
        this.tongzhiContent = tongzhiContent;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Shebei{" +
            "id=" + id +
            ", sbname=" + sbname +
            ", sbimgPhoto=" + sbimgPhoto +
            ", shebeiTypes=" + shebeiTypes +
            ", tongzhiContent=" + tongzhiContent +
            ", createTime=" + createTime +
        "}";
    }
}
