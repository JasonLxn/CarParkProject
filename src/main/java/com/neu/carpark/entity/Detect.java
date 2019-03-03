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
 * @since 2019-03-03
 */
public class Detect implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("dete_id")
    private String deteId;
    @TableField("dete_bstate")
    private String deteBstate;
    @TableField("dete_atate")
    private String deteAtate;
    @TableField("dete_title")
    private String deteTitle;
    @TableField("dete_meg")
    private String deteMeg;
    @TableField("dete_time")
    private Date deteTime;
    @TableField("dete_parkid")
    private String deteParkid;
    @TableField("dete_operid")
    private String deteOperid;


    public String getDeteId() {
        return deteId;
    }

    public void setDeteId(String deteId) {
        this.deteId = deteId;
    }

    public String getDeteBstate() {
        return deteBstate;
    }

    public void setDeteBstate(String deteBstate) {
        this.deteBstate = deteBstate;
    }

    public String getDeteAtate() {
        return deteAtate;
    }

    public void setDeteAtate(String deteAtate) {
        this.deteAtate = deteAtate;
    }

    public String getDeteTitle() {
        return deteTitle;
    }

    public void setDeteTitle(String deteTitle) {
        this.deteTitle = deteTitle;
    }

    public String getDeteMeg() {
        return deteMeg;
    }

    public void setDeteMeg(String deteMeg) {
        this.deteMeg = deteMeg;
    }

    public Date getDeteTime() {
        return deteTime;
    }

    public void setDeteTime(Date deteTime) {
        this.deteTime = deteTime;
    }

    public String getDeteParkid() {
        return deteParkid;
    }

    public void setDeteParkid(String deteParkid) {
        this.deteParkid = deteParkid;
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
        ", deteBstate=" + deteBstate +
        ", deteAtate=" + deteAtate +
        ", deteTitle=" + deteTitle +
        ", deteMeg=" + deteMeg +
        ", deteTime=" + deteTime +
        ", deteParkid=" + deteParkid +
        ", deteOperid=" + deteOperid +
        "}";
    }
}
