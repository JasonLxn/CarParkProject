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
public class Userrole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ur_id")
    private Integer urId;
    @TableField("ur_allid")
    private String urAllid;
    @TableField("ur_roid")
    private Integer urRoid;


    public Integer getUrId() {
        return urId;
    }

    public void setUrId(Integer urId) {
        this.urId = urId;
    }

    public String getUrAllid() {
        return urAllid;
    }

    public void setUrAllid(String urAllid) {
        this.urAllid = urAllid;
    }

    public Integer getUrRoid() {
        return urRoid;
    }

    public void setUrRoid(Integer urRoid) {
        this.urRoid = urRoid;
    }

    @Override
    public String toString() {
        return "Userrole{" +
        "urId=" + urId +
        ", urAllid=" + urAllid +
        ", urRoid=" + urRoid +
        "}";
    }
}
