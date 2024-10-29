package com.entity.model;

import com.entity.KaoqinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 考勤
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-31
 */
public class KaoqinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 签到课堂
     */
    private String qdname;


    /**
     * 签到人
     */
    private Integer yonghuId;


    /**
     * 签到时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date qiandaoTime;


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
	 * 获取：签到课堂
	 */
    public String getQdname() {
        return qdname;
    }


    /**
	 * 设置：签到课堂
	 */
    public void setQdname(String qdname) {
        this.qdname = qdname;
    }
    /**
	 * 获取：签到人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：签到人
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：签到时间
	 */
    public Date getQiandaoTime() {
        return qiandaoTime;
    }


    /**
	 * 设置：签到时间
	 */
    public void setQiandaoTime(Date qiandaoTime) {
        this.qiandaoTime = qiandaoTime;
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
