package com.ecommerce.inditex.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    /**
     * Parses the string to local date.
     *
     * @param dateStr the date str
     * @param format the format
     * @return the local date
     */
    public static LocalDate parseStringToLocalDate(String dateStr, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.parse(dateStr, formatter);
    }

    /**
     * Format local date to string.
     *
     * @param date the date
     * @param format the format
     * @return the string
     */
    public static String formatLocalDateToString(LocalDate date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return date.format(formatter);
    }
}
