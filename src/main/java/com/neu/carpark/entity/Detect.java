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
 * @since 2019-01-29
 */
public class Detect implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("dete_id")
    private String deteId;
    @TableField("dete_state")
    private String deteState;
    @TableField("dete_creattime")
    private Date deteCreattime;
    @TableField("dete_endtime")
    private Date deteEndtime;
    @TableField("dete_febaid")
    private String deteFebaid;
    @TableField("dete_operid")
    private String deteOperid;


    public String getDeteId() {
        return deteId;
    }

    public void setDeteId(String deteId) {
        this.deteId = deteId;
    }

    public String getDeteState() {
        return deteState;
    }

    public void setDeteState(String deteState) {
        this.deteState = deteState;
    }

    public Date getDeteCreattime() {
        return deteCreattime;
    }

    public void setDeteCreattime(Date deteCreattime) {
        this.deteCreattime = deteCreattime;
    }

    public Date getDeteEndtime() {
        return deteEndtime;
    }

    public void setDeteEndtime(Date deteEndtime) {
        this.deteEndtime = deteEndtime;
    }

    public String getDeteFebaid() {
        return deteFebaid;
    }

    public void setDeteFebaid(String deteFebaid) {
        this.deteFebaid = deteFebaid;
    }

    public String getDeteOperid() {
        return deteOperid;
    }

    public void setDeteOperid(String deteOperid) {
        this.deteOperid = deteOperid;
    }

    @Override
    public String toString() {
        return "Detect{" +
        "deteId=" + deteId +
        ", deteState=" + deteState +
        ", deteCreattime=" + deteCreattime +
        ", deteEndtime=" + deteEndtime +
        ", deteFebaid=" + deteFebaid +
        ", deteOperid=" + deteOperid +
        "}";
    }
}
