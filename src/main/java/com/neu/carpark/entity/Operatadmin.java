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
public class Operatadmin implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("opad_id")
    private String opadId;
    @TableField("opad_act")
    private String opadAct;
    @TableField("opad_pwd")
    private String opadPwd;
    @TableField("opad_carpid")
    private String opadCarpid;


    public String getOpadId() {
        return opadId;
    }

    public void setOpadId(String opadId) {
        this.opadId = opadId;
    }

    public String getOpadAct() {
        return opadAct;
    }

    public void setOpadAct(String opadAct) {
        this.opadAct = opadAct;
    }

    public String getOpadPwd() {
        return opadPwd;
    }

    public void setOpadPwd(String opadPwd) {
        this.opadPwd = opadPwd;
    }

    public String getOpadCarpid() {
        return opadCarpid;
    }

    public void setOpadCarpid(String opadCarpid) {
        this.opadCarpid = opadCarpid;
    }

    @Override
    public String toString() {
        return "Operatadmin{" +
        "opadId=" + opadId +
        ", opadAct=" + opadAct +
        ", opadPwd=" + opadPwd +
        ", opadCarpid=" + opadCarpid +
        "}";
    }
}
