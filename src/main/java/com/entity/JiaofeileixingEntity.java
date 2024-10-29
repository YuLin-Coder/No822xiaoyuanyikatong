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
 * 缴费类型
 *
 * @author 
 * @email
 * @date 2021-03-31
 */
@TableName("jiaofeileixing")
public class JiaofeileixingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiaofeileixingEntity() {

	}

	public JiaofeileixingEntity(T t) {
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
    @TableField(value = "name")

    private String name;


    /**
     * 缴费金额
     */
    @TableField(value = "money")

    private Double money;


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
    public String getName() {
        return name;
    }


    /**
	 * 获取：设备名称
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：缴费金额
	 */
    public Double getMoney() {
        return money;
    }


    /**
	 * 获取：缴费金额
	 */

    public void setMoney(Double money) {
        this.money = money;
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
        return "Jiaofeileixing{" +
            "id=" + id +
            ", name=" + name +
            ", money=" + money +
            ", createTime=" + createTime +
        "}";
    }
}
