package com.lvzu.utils;

import java.text.SimpleDateFormat;

/**
 * Created by zhibinglv on 2018/1/10.
 */
public class CommonUtil {
    public static java.sql.Date StringToDate(String dateString){
        String str = dateString;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = null;
        try {
            d = format.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.sql.Date date = new java.sql.Date(d.getTime());
        return date;
    }
}
