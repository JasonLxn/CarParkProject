package com.neu.carpark.entity;

import com.baomidou.mybatisplus.enums.IdType;
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
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ro_id", type = IdType.AUTO)
    private Integer roId;
    @TableField("ro_name")
    private String roName;


    public Integer getRoId() {
        return roId;
    }

    public void setRoId(Integer roId) {
        this.roId = roId;
    }

    public String getRoName() {
        return roName;
    }

    public void setRoName(String roName) {
        this.roName = roName;
    }

    @Override
    public String toString() {
        return "Role{" +
        "roId=" + roId +
        ", roName=" + roName +
        "}";
    }
}
