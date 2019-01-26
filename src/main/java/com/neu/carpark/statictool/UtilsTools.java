package com.neu.carpark.statictool;

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
}
