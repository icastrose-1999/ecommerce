package com.ecommerce.inditex.utils;


/**
 * The Class StringUtils.
 */
public class StringUtils {


    /**
     * Checks if is null or empty.
     *
     * @param str the str
     * @return true, if is null or empty
     */
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    /**
     * Capitalize first letter.
     *
     * @param str the str
     * @return the string
     */
    public static String capitalizeFirstLetter(String str) {
        if (isNullOrEmpty(str)) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    /**
     * Clean string.
     *
     * @param str the str
     * @return the string
     */
    public static String cleanString(String str) {
        if (str == null) {
            return null;
        }
        return str.trim().replaceAll("\\s+", " ");
    }
}
