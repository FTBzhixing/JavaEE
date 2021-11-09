package com.ftb.async.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static String currentDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return now.format(formatter);
    }

    public static void period(String date1, String date2) {
//        Period.between(date2,date1)

    }

    public static void main(String[] args) {
        System.out.println("A");
    }
}
