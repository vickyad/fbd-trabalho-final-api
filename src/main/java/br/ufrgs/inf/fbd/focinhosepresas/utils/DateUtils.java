package br.ufrgs.inf.fbd.focinhosepresas.utils;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateUtils {
    private static final String[] DAYS_OF_WEEK = {"seg", "ter", "qua", "qui", "sex", "sab", "dom"};

    public static String getDowPt(LocalDate date) {
        int dayOfWeek = date.getDayOfWeek().getValue();
        return DAYS_OF_WEEK[dayOfWeek - 1];
    }

    public static LocalTime addHours(LocalTime time, int hours) {
        return time.plusHours(hours);
    }
}
