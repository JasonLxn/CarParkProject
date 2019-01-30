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
 * @since 2019-01-29
 */
public class Alluser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("all_id")
    private String allId;
    @TableField("all_account")
    private String allAccount;
    @TableField("all_pwd")
    private String allPwd;
    @TableField("all_salt")
    private String allSalt;
    @TableField("all_state")
    private String allState;


    public String getAllId() {
        return allId;
    }

    public void setAllId(String allId) {
        this.allId = allId;
    }

    public String getAllAccount() {
        return allAccount;
    }

    public void setAllAccount(String allAccount) {
        this.allAccount = allAccount;
    }

    public String getAllPwd() {
        return allPwd;
    }

    public void setAllPwd(String allPwd) {
        this.allPwd = allPwd;
    }

    public String getAllSalt() {
        return allSalt;
    }

    public void setAllSalt(String allSalt) {
        this.allSalt = allSalt;
    }

    public String getAllState() {
        return allState;
    }

    public void setAllState(String allState) {
        this.allState = allState;
    }

    @Override
    public String toString() {
        return "Alluser{" +
        "allId=" + allId +
        ", allAccount=" + allAccount +
        ", allPwd=" + allPwd +
        ", allSalt=" + allSalt +
        ", allState=" + allState +
        "}";
    }
}
