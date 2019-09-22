package com.zzl.example.jdk8.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: zhile.Zhang
 * @date: 2019/9/21
 * @desc: 使用Java8 的时间工具类操作
 * 文章地址 ： https://mp.weixin.qq.com/s/LApq4yRlF57Aipx4fw7TuQ
 **/
public class LocalDateTimeCase {

    public static void main(String[] args) {
        LocalDate localDate=LocalDate.of(2014,2,12);
        LocalTime localTime=LocalTime.now();
        System.out.println(localDate.toString());
        System.out.println(localDate.toString());
        LocalDateTime localDateTime=LocalDateTime.of(localDate,localTime);
        System.out.println(localDateTime.toString());
        String format = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(localDateTime.toString());
        System.out.println(format);
    }


}
