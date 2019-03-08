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
 * @since 2019-03-04
 */
public class Funds implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("fund_id")
    private String fundId;
    @TableField("fund_creattime")
    private Date fundCreattime;
    @TableField("fund_endtime")
    private Date fundEndtime;
    @TableField("fund_paytime")
    private Date fundPaytime;
    @TableField("fund_parktime")
    private Double fundParktime;
    @TableField("fund_money")
    private Double fundMoney;
    @TableField("fund_state")
    private String fundState;
    @TableField("fund_parkid")
    private String fundParkid;
    @TableField("fund_userid")
    private String fundUserid;

    private Parking parking;
    private Users users;

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public Date getFundCreattime() {
        return fundCreattime;
    }

    public void setFundCreattime(Date fundCreattime) {
        this.fundCreattime = fundCreattime;
    }

    public Date getFundEndtime() {
        return fundEndtime;
    }

    public void setFundEndtime(Date fundEndtime) {
        this.fundEndtime = fundEndtime;
    }

    public Date getFundPaytime() {
        return fundPaytime;
    }

    public void setFundPaytime(Date fundPaytime) {
        this.fundPaytime = fundPaytime;
    }

    public Double getFundParktime() {
        return fundParktime;
    }

    public void setFundParktime(Double fundParktime) {
        this.fundParktime = fundParktime;
    }

    public Double getFundMoney() {
        return fundMoney;
    }

    public void setFundMoney(Double fundMoney) {
        this.fundMoney = fundMoney;
    }

    public String getFundState() {
        return fundState;
    }

    public void setFundState(String fundState) {
        this.fundState = fundState;
    }

    public String getFundParkid() {
        return fundParkid;
    }

    public void setFundParkid(String fundParkid) {
        this.fundParkid = fundParkid;
    }

    public String getFundUserid() {
        return fundUserid;
    }

    public void setFundUserid(String fundUserid) {
        this.fundUserid = fundUserid;
    }

    @Override
    public String toString() {
        return "Funds{" +
                "fundId='" + fundId + '\'' +
                ", fundCreattime=" + fundCreattime +
                ", fundEndtime=" + fundEndtime +
                ", fundPaytime=" + fundPaytime +
                ", fundParktime=" + fundParktime +
                ", fundMoney=" + fundMoney +
                ", fundState='" + fundState + '\'' +
                ", fundParkid='" + fundParkid + '\'' +
                ", fundUserid='" + fundUserid + '\'' +
                ", parking=" + parking +
                ", users=" + users +
                '}';
    }
}
