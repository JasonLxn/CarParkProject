package com.neu.carpark.statictool;

import com.neu.carpark.entity.Alluser;
import org.apache.shiro.SecurityUtils;

import java.util.UUID;

public class UtilsTools {

    /**
     * 获取UUID
     * @return uuid
     */
    public static String uuid(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }
    /**
     * 获取登录的用户实例
     * @return 登录用户实例
     */
    public static Alluser getuser() {
        return (Alluser) SecurityUtils.getSubject().getPrincipal();
    }
}
