package com.wuhan.mall.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 处理日期类型变量的工具类
 * @author sunweijia
 * @since 2018/12/12
 */
public class DateUtil {
    /**
     * 获取两个日期之间的日期
     * @param start 开始日期
     * @param end 结束日期
     * @return 日期字符串格式的集合
     */
    public static List<Date> getBetweenDates(Date start, Date end) {
        List<Date> result = new ArrayList<Date>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);

        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);
        while (tempStart.before(tempEnd) || tempStart.equals(tempEnd)) {
            result.add(tempStart.getTime());
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }
        return result;
    }

    /**
     * 根据日期字符串返回日期
     * @param source
     * @param format
     * @return
     * @throws ParseException
     */
    public static final Date parse(String source,String format) throws ParseException {
        DateFormat df = new SimpleDateFormat(format);
        return df.parse(source);
    }

    /**
     * 根据日期获取格式化的日期字符串
     * @param date
     * @param format
     * @return
     * @throws ParseException
     */
    public static final String format(Date date,String format) throws ParseException {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /**
     * @param date
     * @param number
     * @return
     *
     * 根据设置的日期，增加几个月
     */
    public static final Date setime(Date date,Integer number){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);//设置起时间
        calendar.add(Calendar.MONTH,number);
        return calendar.getTime();
    }

    public static int compare_date(String DATE1, String DATE2,String DATE3) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            Date dt3 = df.parse(DATE3);
            if(dt3.getTime() < dt2.getTime()){
                //System.out.println("活动已结束");
                return 2;
            }else if (dt1.getTime() > dt2.getTime()) {
                //System.out.println("活动未开始");
                return 0;
            } else if (dt1.getTime() < dt2.getTime()) {
                //System.out.println("活动已开始");
                return 1;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 3;
    }

}
