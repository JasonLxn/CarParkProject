
package com.neu.carpark.statictool;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期处理
 *
 */
public class DateUtils {
	/** 时间格式(yyyy-MM-dd) */
	public final static String DATE_PATTERN = "yyyy-MM-dd";
	/** 时间格式(yyyy-MM-dd HH:mm:ss) */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期格式化 日期格式为：yyyy-MM-dd
     * @param date  日期
     * @return  返回yyyy-MM-dd格式日期
     */
	public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    /**
     * 日期格式化 日期格式为：yyyy-MM-dd
     * @param date  日期
     * @param pattern  格式，如：DateUtils.DATE_TIME_PATTERN
     * @return  返回yyyy-MM-dd格式日期
     */
    public static String format(Date date, String pattern) {
        if(date != null){
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    /**
     * 字符串转换成日期
     * @param strDate 日期字符串
     * @param pattern 日期的格式，如：DateUtils.DATE_TIME_PATTERN
     */
    public static Date stringToDate(String strDate, String pattern) {
        if (StringUtils.isBlank(strDate)){
            return null;
        }

        DateTimeFormatter fmt = DateTimeFormat.forPattern(pattern);
        return fmt.parseLocalDateTime(strDate).toDate();
    }

    /**
     * 根据周数，获取开始日期、结束日期
     * @param week  周期  0本周，-1上周，-2上上周，1下周，2下下周
     * @return  返回date[0]开始日期、date[1]结束日期
     */
    public static Date[] getWeekStartAndEnd(int week) {
        DateTime dateTime = new DateTime();
        LocalDate date = new LocalDate(dateTime.plusWeeks(week));

        date = date.dayOfWeek().withMinimumValue();
        Date beginDate = date.toDate();
        Date endDate = date.plusDays(6).toDate();
        return new Date[]{beginDate, endDate};
    }

    /**
     * 对日期的【秒】进行加/减
     *
     * @param date 日期
     * @param seconds 秒数，负数为减
     * @return 加/减几秒后的日期
     */
    public static Date addDateSeconds(Date date, int seconds) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusSeconds(seconds).toDate();
    }

    /**
     * 对日期的【分钟】进行加/减
     *
     * @param date 日期
     * @param minutes 分钟数，负数为减
     * @return 加/减几分钟后的日期
     */
    public static Date addDateMinutes(Date date, int minutes) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusMinutes(minutes).toDate();
    }

    /**
     * 对日期的【小时】进行加/减
     *
     * @param date 日期
     * @param hours 小时数，负数为减
     * @return 加/减几小时后的日期
     */
    public static Date addDateHours(Date date, int hours) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusHours(hours).toDate();
    }

    /**
     * 对日期的【天】进行加/减
     *
     * @param date 日期
     * @param days 天数，负数为减
     * @return 加/减几天后的日期
     */
    public static Date addDateDays(Date date, int days) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusDays(days).toDate();
    }

    /**
     * 对日期的【周】进行加/减
     *
     * @param date 日期
     * @param weeks 周数，负数为减
     * @return 加/减几周后的日期
     */
    public static Date addDateWeeks(Date date, int weeks) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusWeeks(weeks).toDate();
    }

    /**
     * 对日期的【月】进行加/减
     *
     * @param date 日期
     * @param months 月数，负数为减
     * @return 加/减几月后的日期
     */
    public static Date addDateMonths(Date date, int months) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusMonths(months).toDate();
    }

    /**
     * 对日期的【年】进行加/减
     *
     * @param date 日期
     * @param years 年数，负数为减
     * @return 加/减几年后的日期
     */
    public static Date addDateYears(Date date, int years) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusYears(years).toDate();
    }

    /**
     * 计算时间差
     * @param endDate 结束时间
     * @param creatDate 开始时间
     * @return
     */
    public static String getDatePoor(Date endDate, Date creatDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - creatDate.getTime();
        // 计算差多少小时
        long hour = diff / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒
        long sec = diff % nd % nh % nm / ns;
        return hour+":"+min+":"+sec;
    }

    /**
     * 规定日期多少天数内的日期列表
     * @param date 规定日期
     * @param day 天数
     * @return 日期列表
     */
    public static List<String> getDayList(Date date,int day){
        day=-day;
        List<String> datelist=new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        datelist.add(sdf.format(date));
        for(int i=-1;i>day;i--){
            Date time=addDateDays(date,i);
            datelist.add(sdf.format(time));
        }
        //反转排序
        Collections.reverse(datelist);
        return datelist;
    }

    /**
     * 获取指定年月的日期列表
     * @param year 年份
     * @param month 月份
     * @return
     */
    public static List<String> getMonthList(int year,int month){
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        Calendar cal = Calendar.getInstance();
        int lastDay;
        //当输入的月份为当前月份时，输出日期列表截止为当前日期
        if(month==cal.get(Calendar.MONTH)+1){
            lastDay=cal.get(Calendar.DATE);
            cal.set(Calendar.DAY_OF_MONTH,1);
        }else{
            cal.clear();
            cal.set(Calendar.YEAR,year);//设置年份
            cal.set(Calendar.MONTH, month-1);//设置月份
            lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);//获取某月最大天数
            cal.set(Calendar.DAY_OF_MONTH,1);
        }
        List<String> monthlist=new ArrayList<>();
        monthlist.add(sdf.format(cal.getTime()));
        for(int i=1;i<lastDay;i++){
            Date time=addDateDays(cal.getTime(),i);
            monthlist.add(sdf.format(time));
        }
        return monthlist;
    }

    /**
     * 获取当前年月格式为：201904
     * @return
     */
    public static String getNowYearmonths(){
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMM");
        return sdf.format(new Date());
    }
}
