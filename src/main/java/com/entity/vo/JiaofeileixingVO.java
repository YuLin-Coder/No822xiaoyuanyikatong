package com.entity.vo;

import com.entity.JiaofeileixingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 缴费类型
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-31
 */
@TableName("jiaofeileixing")
public class JiaofeileixingVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "create_time")
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

}
