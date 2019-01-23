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
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("user_id")
    private String userId;
    @TableField("user_name")
    private String userName;
    @TableField("user_sex")
    private String userSex;
    @TableField("user_phone")
    private String userPhone;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Override
    public String toString() {
        return "Users{" +
        "userId=" + userId +
        ", userName=" + userName +
        ", userSex=" + userSex +
        ", userPhone=" + userPhone +
        "}";
    }
}
