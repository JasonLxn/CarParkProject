package com.neu.carpark.entity;

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
public class Parking implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("park_id")
    private String parkId;
    @TableField("park_num")
    private String parkNum;
    @TableField("park_state")
    private String parkState;
    @TableField("park_carpid")
    private String parkCarpid;


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

    public String getParkCarpid() {
        return parkCarpid;
    }

    public void setParkCarpid(String parkCarpid) {
        this.parkCarpid = parkCarpid;
    }

    @Override
    public String toString() {
        return "Parking{" +
        "parkId=" + parkId +
        ", parkNum=" + parkNum +
        ", parkState=" + parkState +
        ", parkCarpid=" + parkCarpid +
        "}";
    }
}
