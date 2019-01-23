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
public class Operat implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("oper_id")
    private String operId;
    @TableField("oper_worknum")
    private String operWorknum;
    @TableField("oper_name")
    private String operName;
    @TableField("oper_sex")
    private String operSex;
    @TableField("oper_phone")
    private String operPhone;
    @TableField("oper_position")
    private String operPosition;


    public String getOperId() {
        return operId;
    }

    public void setOperId(String operId) {
        this.operId = operId;
    }

    public String getOperWorknum() {
        return operWorknum;
    }

    public void setOperWorknum(String operWorknum) {
        this.operWorknum = operWorknum;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    public String getOperSex() {
        return operSex;
    }

    public void setOperSex(String operSex) {
        this.operSex = operSex;
    }

    public String getOperPhone() {
        return operPhone;
    }

    public void setOperPhone(String operPhone) {
        this.operPhone = operPhone;
    }

    public String getOperPosition() {
        return operPosition;
    }

    public void setOperPosition(String operPosition) {
        this.operPosition = operPosition;
    }

    @Override
    public String toString() {
        return "Operat{" +
        "operId=" + operId +
        ", operWorknum=" + operWorknum +
        ", operName=" + operName +
        ", operSex=" + operSex +
        ", operPhone=" + operPhone +
        ", operPosition=" + operPosition +
        "}";
    }
}
