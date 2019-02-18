package com.neu.carpark.entity.bean;

public class ParkTimeNum {
    private String dateTime;
    private String useNum;
    private String errorNum;
    private String serviceNum;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getUseNum() {
        return useNum;
    }

    public void setUseNum(String useNum) {
        this.useNum = useNum;
    }

    public String getErrorNum() {
        return errorNum;
    }

    public void setErrorNum(String errorNum) {
        this.errorNum = errorNum;
    }

    public String getServiceNum() {
        return serviceNum;
    }

    public void setServiceNum(String serviceNum) {
        this.serviceNum = serviceNum;
    }

    @Override
    public String toString() {
        return "ParkTimeNum{" +
                "dateTime='" + dateTime + '\'' +
                ", useNum='" + useNum + '\'' +
                ", errorNum='" + errorNum + '\'' +
                ", serviceNum='" + serviceNum + '\'' +
                '}';
    }
}
