package com.entity.vo;

import com.entity.JiehuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 设备借还
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-31
 */
@TableName("jiehuan")
public class JiehuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "zhujie_time")
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

    @TableField(value = "guihuan_time")
    private Date guihuanTime;


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

}
