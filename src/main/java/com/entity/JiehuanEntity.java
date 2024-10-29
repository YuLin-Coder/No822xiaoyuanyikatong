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
 * 设备借还
 *
 * @author 
 * @email
 * @date 2021-03-31
 */
@TableName("jiehuan")
public class JiehuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiehuanEntity() {

	}

	public JiehuanEntity(T t) {
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
    @TableField(value = "shebei_id")

    private Integer shebeiId;


    /**
     * 租借人
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 租借时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "zhujie_time",fill = FieldFill.UPDATE)

    private Date zhujieTime;


    /**
     * 租借状态
     */
    @TableField(value = "zhujie_types")

    private Integer zhujieTypes;


    /**
     * 设备归还时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "guihuan_time",fill = FieldFill.UPDATE)

    private Date guihuanTime;


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
    public Integer getShebeiId() {
        return shebeiId;
    }


    /**
	 * 获取：设备名称
	 */

    public void setShebeiId(Integer shebeiId) {
        this.shebeiId = shebeiId;
    }
    /**
	 * 设置：租借人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：租借人
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：租借时间
	 */
    public Date getZhujieTime() {
        return zhujieTime;
    }


    /**
	 * 获取：租借时间
	 */

    public void setZhujieTime(Date zhujieTime) {
        this.zhujieTime = zhujieTime;
    }
    /**
	 * 设置：租借状态
	 */
    public Integer getZhujieTypes() {
        return zhujieTypes;
    }


    /**
	 * 获取：租借状态
	 */

    public void setZhujieTypes(Integer zhujieTypes) {
        this.zhujieTypes = zhujieTypes;
    }
    /**
	 * 设置：设备归还时间
	 */
    public Date getGuihuanTime() {
        return guihuanTime;
    }


    /**
	 * 获取：设备归还时间
	 */

    public void setGuihuanTime(Date guihuanTime) {
        this.guihuanTime = guihuanTime;
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
        return "Jiehuan{" +
            "id=" + id +
            ", shebeiId=" + shebeiId +
            ", yonghuId=" + yonghuId +
            ", zhujieTime=" + zhujieTime +
            ", zhujieTypes=" + zhujieTypes +
            ", guihuanTime=" + guihuanTime +
            ", createTime=" + createTime +
        "}";
    }
}
