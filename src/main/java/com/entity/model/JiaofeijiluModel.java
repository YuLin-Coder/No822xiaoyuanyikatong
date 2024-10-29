package com.entity.model;

import com.entity.JiaofeijiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 缴费记录
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-31
 */
public class JiaofeijiluModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 消费原因
     */
    private String xfname;


    /**
     * 消费人
     */
    private Integer yonghuId;


    /**
     * 消费金额
     */
    private Double xfmoney;


    /**
     * 消费时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date xiaofeiTime;


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
	 * 获取：消费原因
	 */
    public String getXfname() {
        return xfname;
    }


    /**
	 * 设置：消费原因
	 */
    public void setXfname(String xfname) {
        this.xfname = xfname;
    }
    /**
	 * 获取：消费人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：消费人
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：消费金额
	 */
    public Double getXfmoney() {
        return xfmoney;
    }


    /**
	 * 设置：消费金额
	 */
    public void setXfmoney(Double xfmoney) {
        this.xfmoney = xfmoney;
    }
    /**
	 * 获取：消费时间
	 */
    public Date getXiaofeiTime() {
        return xiaofeiTime;
    }


    /**
	 * 设置：消费时间
	 */
    public void setXiaofeiTime(Date xiaofeiTime) {
        this.xiaofeiTime = xiaofeiTime;
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
