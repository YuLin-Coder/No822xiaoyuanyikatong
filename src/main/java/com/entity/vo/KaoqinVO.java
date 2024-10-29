package com.entity.vo;

import com.entity.KaoqinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 考勤
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-31
 */
@TableName("kaoqin")
public class KaoqinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "qiandao_time")
    private Date qiandaoTime;


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

}
