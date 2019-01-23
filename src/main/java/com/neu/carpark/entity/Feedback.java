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
public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("feba_id")
    private String febaId;
    @TableField("feba_title")
    private String febaTitle;
    @TableField("feba_meg")
    private String febaMeg;
    @TableField("feba_usertime")
    private Date febaUsertime;
    @TableField("feba_state")
    private String febaState;
    @TableField("feba_opertime")
    private Date febaOpertime;
    @TableField("feba_operid")
    private String febaOperid;
    @TableField("feba_userid")
    private String febaUserid;


    public String getFebaId() {
        return febaId;
    }

    public void setFebaId(String febaId) {
        this.febaId = febaId;
    }

    public String getFebaTitle() {
        return febaTitle;
    }

    public void setFebaTitle(String febaTitle) {
        this.febaTitle = febaTitle;
    }

    public String getFebaMeg() {
        return febaMeg;
    }

    public void setFebaMeg(String febaMeg) {
        this.febaMeg = febaMeg;
    }

    public Date getFebaUsertime() {
        return febaUsertime;
    }

    public void setFebaUsertime(Date febaUsertime) {
        this.febaUsertime = febaUsertime;
    }

    public String getFebaState() {
        return febaState;
    }

    public void setFebaState(String febaState) {
        this.febaState = febaState;
    }

    public Date getFebaOpertime() {
        return febaOpertime;
    }

    public void setFebaOpertime(Date febaOpertime) {
        this.febaOpertime = febaOpertime;
    }

    public String getFebaOperid() {
        return febaOperid;
    }

    public void setFebaOperid(String febaOperid) {
        this.febaOperid = febaOperid;
    }

    public String getFebaUserid() {
        return febaUserid;
    }

    public void setFebaUserid(String febaUserid) {
        this.febaUserid = febaUserid;
    }

    @Override
    public String toString() {
        return "Feedback{" +
        "febaId=" + febaId +
        ", febaTitle=" + febaTitle +
        ", febaMeg=" + febaMeg +
        ", febaUsertime=" + febaUsertime +
        ", febaState=" + febaState +
        ", febaOpertime=" + febaOpertime +
        ", febaOperid=" + febaOperid +
        ", febaUserid=" + febaUserid +
        "}";
    }
}
