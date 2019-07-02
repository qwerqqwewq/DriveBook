package com.zte.drive.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @Author:helloboy
 * @Date:2019-06-25 10:47
 * Description:<描述>
 */
public class CurrentDate {
    /**
     * 获取当前系统时间
     * @return String 当前系统时间
     */
    public static String getCurrentDate(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
    }
}
