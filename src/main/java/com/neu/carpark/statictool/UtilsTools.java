package com.neu.carpark.statictool;

import com.neu.carpark.entity.Alluser;
import org.apache.shiro.SecurityUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

    /**
     * 获得两个月份数据相比的增速
     */
    public static BigDecimal sumIncease(double nowmonth,double leftmonth){
        double speed;
        if(leftmonth==0){
            speed=100;
        }else{
            speed=((nowmonth/leftmonth)-1)*100;
        }
        BigDecimal bg = new BigDecimal(speed).setScale(2, RoundingMode.UP);
        return bg;
    }
}
