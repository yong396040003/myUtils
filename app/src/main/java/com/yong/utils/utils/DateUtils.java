package com.yong.utils.utils;

/**
 * @Description: 自定义日期封装类
 * @Author: yong
 * @time 2020/6/27 9:23
 * @Version: 1.0
 */
public class DateUtils {

    /**
     * 格式化日期
     *
     * @param year
     * @param monthOfYear
     * @param dayOfMonth
     * @return
     */
    public static String format(int year, int monthOfYear, int dayOfMonth) {
        String y = "";
        String m = "";
        String d = "";
        if (year > 9) {
            y = year + "";
        } else {
            y = "0" + year;
        }
        if (monthOfYear > 9) {
            m = monthOfYear + "";
        } else {
            m = "0" + monthOfYear;
        }
        if (dayOfMonth > 9) {
            d = dayOfMonth + "";
        } else {
            d = "0" + dayOfMonth;
        }

        return y + "-" + m + "-" + d;
    }
}