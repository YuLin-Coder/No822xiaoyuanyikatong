package com.entity.model;

import com.entity.JiehuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 设备借还
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-31
 */
public class JiehuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 设备名称
     */
    private Integer shebeiId;


    /**
     * 租借人
     */
    private Integer yonghuId;


    /**
     * 租借时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date zhujieTime;


    /**
     * 租借状态
     */
    private Integer zhujieTypes;


    /**
     * 设备归还时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date guihuanTime;


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
    public Integer getShebeiId() {
        return shebeiId;
    }


    /**
	 * 设置：设备名称
	 */
    public void setShebeiId(Integer shebeiId) {
        this.shebeiId = shebeiId;
    }
    /**
	 * 获取：租借人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：租借人
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：租借时间
	 */
    public Date getZhujieTime() {
        return zhujieTime;
    }


    /**
	 * 设置：租借时间
	 */
    public void setZhujieTime(Date zhujieTime) {
        this.zhujieTime = zhujieTime;
    }
    /**
	 * 获取：租借状态
	 */
    public Integer getZhujieTypes() {
        return zhujieTypes;
    }


    /**
	 * 设置：租借状态
	 */
    public void setZhujieTypes(Integer zhujieTypes) {
        this.zhujieTypes = zhujieTypes;
    }
    /**
	 * 获取：设备归还时间
	 */
    public Date getGuihuanTime() {
        return guihuanTime;
    }


    /**
	 * 设置：设备归还时间
	 */
    public void setGuihuanTime(Date guihuanTime) {
        this.guihuanTime = guihuanTime;
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
