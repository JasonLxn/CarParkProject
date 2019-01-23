package com.neu.carpark.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lxn123
 * @since 2019-01-21
 */
public class Parkchange implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("parc_id")
    private String parcId;
    @TableField("parc_bstate")
    private String parcBstate;
    @TableField("parc_astate")
    private String parcAstate;
    @TableField("parc_time")
    private Date parcTime;
    @TableField("parc_reason")
    private String parcReason;
    @TableField("parc_operid")
    private String parcOperid;
    @TableField("parc_parkid")
    private String parcParkid;


    public String getParcId() {
        return parcId;
    }

    public void setParcId(String parcId) {
        this.parcId = parcId;
    }

    public String getParcBstate() {
        return parcBstate;
    }

    public void setParcBstate(String parcBstate) {
        this.parcBstate = parcBstate;
    }

    public String getParcAstate() {
        return parcAstate;
    }

    public void setParcAstate(String parcAstate) {
        this.parcAstate = parcAstate;
    }

    public Date getParcTime() {
        return parcTime;
    }

    public void setParcTime(Date parcTime) {
        this.parcTime = parcTime;
    }

    public String getParcReason() {
        return parcReason;
    }

    public void setParcReason(String parcReason) {
        this.parcReason = parcReason;
    }

    public String getParcOperid() {
        return parcOperid;
    }

    public void setParcOperid(String parcOperid) {
        this.parcOperid = parcOperid;
    }

    public String getParcParkid() {
        return parcParkid;
    }

    public void setParcParkid(String parcParkid) {
        this.parcParkid = parcParkid;
    }

    @Override
    public String toString() {
        return "Parkchange{" +
        "parcId=" + parcId +
        ", parcBstate=" + parcBstate +
        ", parcAstate=" + parcAstate +
        ", parcTime=" + parcTime +
        ", parcReason=" + parcReason +
        ", parcOperid=" + parcOperid +
        ", parcParkid=" + parcParkid +
        "}";
    }
}
