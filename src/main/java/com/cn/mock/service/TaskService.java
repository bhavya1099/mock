package com.cn.mock.service;

import java.util.Calendar;
import java.util.Date;

/**
 * Created on 2019/10/15.
 *
 * @author hhx
 */
public class TaskService {
    private static final int YESTERDAY_TASK_LIMIT_HOUR = 8;

    /**
     * 根据任务创建的时间判断任务是否可以执行
     *
     * 如果任务是当天创建的允许执行， 如果是昨天的任务，允许在第二天的早上YESTERDAY_TASK_LIMIT_HOUR点前执行
     * @param taskCreateTime 任务创建时间
     * @return true 任务可以执行， false 任务已过期不可以执行
     */
    public boolean canExecute(Date taskCreateTime) {
        Date now = new Date();
        Calendar nowCalendar = Calendar.getInstance();
        nowCalendar.setTime(now);

        Calendar createTimeCalendar = Calendar.getInstance();
        createTimeCalendar.setTime(taskCreateTime);
        boolean isToday = isSameDay(taskCreateTime, now);

        //如果是当天任务允许执行
        if (isToday) {
            return true;
        }

        nowCalendar.add(Calendar.DATE, -1);
        Date yesterday = nowCalendar.getTime();
        boolean isYesterday = isSameDay(taskCreateTime, yesterday);

        //如果是昨天任务，只允许在8点前执行
        if (isYesterday) {
            return nowCalendar.get(Calendar.HOUR_OF_DAY) < YESTERDAY_TASK_LIMIT_HOUR;
        }

        return false;
    }

    /**
     * 判断两个日期是否为同一天
     * @param date1 date1
     * @param date2 date2
     * @return 是同一天返回true， 否则为false
     */
    private boolean isSameDay(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR)
                && calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH)
                && calendar1.get(Calendar.DAY_OF_MONTH) == calendar2.get(Calendar.DAY_OF_MONTH);
    }
}
