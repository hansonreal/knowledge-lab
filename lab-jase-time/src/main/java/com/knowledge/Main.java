package com.knowledge;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.springframework.util.StringUtils;

@Slf4j
public class Main {
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) {
        boolean allowCreateOrder = isAllowCreateOrder();
        if (allowCreateOrder) {
            log.info("允许创建订单");
        } else {
            log.info("不允许创建订单");
        }
    }


    public static boolean isAllowCreateOrder() {
        String tradeLimtTimeRange = "0-0";
        log.info("[创建订单] - 系统参数【APP_Trade_Limt_Time_Range】配置值为:{}", tradeLimtTimeRange);
        if (StringUtils.hasText(tradeLimtTimeRange)) {
            DateTime now = DateTime.now();
            log.info("[创建订单] - 当前系统时间为:{}", now.toString(DATE_FORMAT));
            String[] tradeLimtTimeRangeArray = tradeLimtTimeRange.split("-");
            String start = tradeLimtTimeRangeArray[0];
            String end = tradeLimtTimeRangeArray[1];
            int startInt = Integer.parseInt(start);
            int endInt = Integer.parseInt(end);
            Interval interval = null;
            if (startInt >= endInt) { // 跨天
                int year = now.getYear();
                int month = now.getMonthOfYear();
                int day = now.getDayOfMonth();
                DateTime beginDateTime = new DateTime(year, month, day, startInt, 0, 0, 0);
                DateTime nextDateTime = now.plusDays(1);
                int nextYear = nextDateTime.getYear();
                int nextMonth = nextDateTime.getMonthOfYear();
                int nextDay = nextDateTime.getDayOfMonth();
                DateTime endDateTime = new DateTime(nextYear, nextMonth, nextDay, endInt, 0, 0, 0);
                log.info("[创建订单] - 系统配置的开始时间为:{},结束时间为:{}",
                        beginDateTime.toString(DATE_FORMAT)
                        , endDateTime.toString(DATE_FORMAT));
                // 计算特定日期是否在该区间内
                interval = new Interval(beginDateTime, endDateTime);
            } else {// 当天
                int year = now.getYear();
                int month = now.getMonthOfYear();
                int day = now.getDayOfMonth();
                DateTime beginDateTime = new DateTime(year, month, day, startInt, 0, 0, 0);
                DateTime endDateTime = new DateTime(year, month, day, endInt, 0, 0, 0);
                log.info("[创建订单] - 系统配置的开始时间为:{},结束时间为:{}",
                        beginDateTime.toString(DATE_FORMAT)
                        , endDateTime.toString(DATE_FORMAT));
                // 计算特定日期是否在该区间内
                interval = new Interval(beginDateTime, endDateTime);
            }
            return !interval.contains(now);

        }
        return true;
    }
}