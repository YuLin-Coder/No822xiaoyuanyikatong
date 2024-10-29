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
 * 考勤
 *
 * @author 
 * @email
 * @date 2021-03-31
 */
@TableName("kaoqin")
public class KaoqinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KaoqinEntity() {

	}

	public KaoqinEntity(T t) {
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
     * 签到课堂
     */
    @TableField(value = "qdname")

    private String qdname;


    /**
     * 签到人
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 签到时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "qiandao_time",fill = FieldFill.UPDATE)

    private Date qiandaoTime;


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
	 * 设置：签到课堂
	 */
    public String getQdname() {
        return qdname;
    }


    /**
	 * 获取：签到课堂
	 */

    public void setQdname(String qdname) {
        this.qdname = qdname;
    }
    /**
	 * 设置：签到人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：签到人
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：签到时间
	 */
    public Date getQiandaoTime() {
        return qiandaoTime;
    }


    /**
	 * 获取：签到时间
	 */

    public void setQiandaoTime(Date qiandaoTime) {
        this.qiandaoTime = qiandaoTime;
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
        return "Kaoqin{" +
            "id=" + id +
            ", qdname=" + qdname +
            ", yonghuId=" + yonghuId +
            ", qiandaoTime=" + qiandaoTime +
            ", createTime=" + createTime +
        "}";
    }
}
