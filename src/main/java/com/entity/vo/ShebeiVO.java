package com.entity.vo;

import com.entity.ShebeiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 设备
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-31
 */
@TableName("shebei")
public class ShebeiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 设备名称
     */

    @TableField(value = "sbname")
    private String sbname;


    /**
     * 设备图片
     */

    @TableField(value = "sbimg_photo")
    private String sbimgPhoto;


    /**
     * 设备状态
     */

    @TableField(value = "shebei_types")
    private Integer shebeiTypes;


    /**
     * 设备信息
     */

    @TableField(value = "tongzhi_content")
    private String tongzhiContent;


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
    public String getSbname() {
        return sbname;
    }


    /**
	 * 获取：设备名称
	 */

    public void setSbname(String sbname) {
        this.sbname = sbname;
    }
    /**
	 * 设置：设备图片
	 */
    public String getSbimgPhoto() {
        return sbimgPhoto;
    }


    /**
	 * 获取：设备图片
	 */

    public void setSbimgPhoto(String sbimgPhoto) {
        this.sbimgPhoto = sbimgPhoto;
    }
    /**
	 * 设置：设备状态
	 */
    public Integer getShebeiTypes() {
        return shebeiTypes;
    }


    /**
	 * 获取：设备状态
	 */

    public void setShebeiTypes(Integer shebeiTypes) {
        this.shebeiTypes = shebeiTypes;
    }
    /**
	 * 设置：设备信息
	 */
    public String getTongzhiContent() {
        return tongzhiContent;
    }


    /**
	 * 获取：设备信息
	 */

    public void setTongzhiContent(String tongzhiContent) {
        this.tongzhiContent = tongzhiContent;
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
