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
 * 缴费记录
 *
 * @author 
 * @email
 * @date 2021-03-31
 */
@TableName("jiaofeijilu")
public class JiaofeijiluEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiaofeijiluEntity() {

	}

	public JiaofeijiluEntity(T t) {
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
     * 消费原因
     */
    @TableField(value = "xfname")

    private String xfname;


    /**
     * 消费人
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 消费金额
     */
    @TableField(value = "xfmoney")

    private Double xfmoney;


    /**
     * 消费时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "xiaofei_time",fill = FieldFill.UPDATE)

    private Date xiaofeiTime;


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
	 * 设置：消费原因
	 */
    public String getXfname() {
        return xfname;
    }


    /**
	 * 获取：消费原因
	 */

    public void setXfname(String xfname) {
        this.xfname = xfname;
    }
    /**
	 * 设置：消费人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：消费人
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：消费金额
	 */
    public Double getXfmoney() {
        return xfmoney;
    }


    /**
	 * 获取：消费金额
	 */

    public void setXfmoney(Double xfmoney) {
        this.xfmoney = xfmoney;
    }
    /**
	 * 设置：消费时间
	 */
    public Date getXiaofeiTime() {
        return xiaofeiTime;
    }


    /**
	 * 获取：消费时间
	 */

    public void setXiaofeiTime(Date xiaofeiTime) {
        this.xiaofeiTime = xiaofeiTime;
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
        return "Jiaofeijilu{" +
            "id=" + id +
            ", xfname=" + xfname +
            ", yonghuId=" + yonghuId +
            ", xfmoney=" + xfmoney +
            ", xiaofeiTime=" + xiaofeiTime +
            ", createTime=" + createTime +
        "}";
    }
}
