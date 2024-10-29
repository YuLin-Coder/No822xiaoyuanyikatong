package com.entity.model;

import com.entity.ChengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 成绩
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-31
 */
public class ChengjiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 考试名称
     */
    private String examName;


    /**
     * 科目
     */
    private Integer kemuTypes;


    /**
     * 分数
     */
    private Double fraction;


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
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：考试名称
	 */
    public String getExamName() {
        return examName;
    }


    /**
	 * 设置：考试名称
	 */
    public void setExamName(String examName) {
        this.examName = examName;
    }
    /**
	 * 获取：科目
	 */
    public Integer getKemuTypes() {
        return kemuTypes;
    }


    /**
	 * 设置：科目
	 */
    public void setKemuTypes(Integer kemuTypes) {
        this.kemuTypes = kemuTypes;
    }
    /**
	 * 获取：分数
	 */
    public Double getFraction() {
        return fraction;
    }


    /**
	 * 设置：分数
	 */
    public void setFraction(Double fraction) {
        this.fraction = fraction;
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
