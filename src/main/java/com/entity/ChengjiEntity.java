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
 * 成绩
 *
 * @author 
 * @email
 * @date 2021-03-31
 */
@TableName("chengji")
public class ChengjiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChengjiEntity() {

	}

	public ChengjiEntity(T t) {
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
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 考试名称
     */
    @TableField(value = "exam_name")

    private String examName;


    /**
     * 科目
     */
    @TableField(value = "kemu_types")

    private Integer kemuTypes;


    /**
     * 分数
     */
    @TableField(value = "fraction")

    private Double fraction;


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
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：考试名称
	 */
    public String getExamName() {
        return examName;
    }


    /**
	 * 获取：考试名称
	 */

    public void setExamName(String examName) {
        this.examName = examName;
    }
    /**
	 * 设置：科目
	 */
    public Integer getKemuTypes() {
        return kemuTypes;
    }


    /**
	 * 获取：科目
	 */

    public void setKemuTypes(Integer kemuTypes) {
        this.kemuTypes = kemuTypes;
    }
    /**
	 * 设置：分数
	 */
    public Double getFraction() {
        return fraction;
    }


    /**
	 * 获取：分数
	 */

    public void setFraction(Double fraction) {
        this.fraction = fraction;
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
        return "Chengji{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", examName=" + examName +
            ", kemuTypes=" + kemuTypes +
            ", fraction=" + fraction +
            ", createTime=" + createTime +
        "}";
    }
}
