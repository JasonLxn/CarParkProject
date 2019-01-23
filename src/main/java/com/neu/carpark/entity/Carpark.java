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
public class Carpark implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("carp_id")
    private String carpId;
    @TableField("carp_name")
    private String carpName;
    @TableField("carp_area")
    private String carpArea;
    @TableField("carp_type")
    private String carpType;
    @TableField("carp_emoney")
    private Double carpEmoney;
    @TableField("carp_bhour")
    private Double carpBhour;
    @TableField("carp_bmoney")
    private Double carpBmoney;
    @TableField("carp_amoney")
    private Double carpAmoney;


    public String getCarpId() {
        return carpId;
    }

    public void setCarpId(String carpId) {
        this.carpId = carpId;
    }

    public String getCarpName() {
        return carpName;
    }

    public void setCarpName(String carpName) {
        this.carpName = carpName;
    }

    public String getCarpArea() {
        return carpArea;
    }

    public void setCarpArea(String carpArea) {
        this.carpArea = carpArea;
    }

    public String getCarpType() {
        return carpType;
    }

    public void setCarpType(String carpType) {
        this.carpType = carpType;
    }

    public Double getCarpEmoney() {
        return carpEmoney;
    }

    public void setCarpEmoney(Double carpEmoney) {
        this.carpEmoney = carpEmoney;
    }

    public Double getCarpBhour() {
        return carpBhour;
    }

    public void setCarpBhour(Double carpBhour) {
        this.carpBhour = carpBhour;
    }

    public Double getCarpBmoney() {
        return carpBmoney;
    }

    public void setCarpBmoney(Double carpBmoney) {
        this.carpBmoney = carpBmoney;
    }

    public Double getCarpAmoney() {
        return carpAmoney;
    }

    public void setCarpAmoney(Double carpAmoney) {
        this.carpAmoney = carpAmoney;
    }

    @Override
    public String toString() {
        return "Carpark{" +
        "carpId=" + carpId +
        ", carpName=" + carpName +
        ", carpArea=" + carpArea +
        ", carpType=" + carpType +
        ", carpEmoney=" + carpEmoney +
        ", carpBhour=" + carpBhour +
        ", carpBmoney=" + carpBmoney +
        ", carpAmoney=" + carpAmoney +
        "}";
    }
}
