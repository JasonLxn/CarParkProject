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
public class Parking implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("park_id")
    private String parkId;
    @TableField("park_num")
    private String parkNum;
    @TableField("park_state")
    private String parkState;
    @TableField("park_time")
    private Date parkTime;


    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }

    public String getParkNum() {
        return parkNum;
    }

    public void setParkNum(String parkNum) {
        this.parkNum = parkNum;
    }

    public String getParkState() {
        return parkState;
    }

    public void setParkState(String parkState) {
        this.parkState = parkState;
    }

    public Date getParkTime() {
        return parkTime;
    }

    public void setParkTime(Date parkTime) {
        this.parkTime = parkTime;
    }

    @Override
    public String toString() {
        return "Parking{" +
        "parkId=" + parkId +
        ", parkNum=" + parkNum +
        ", parkState=" + parkState +
        ", parkTime=" + parkTime +
        "}";
    }
}
