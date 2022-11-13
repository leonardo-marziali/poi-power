package com.leomarzia.poipower.utils;

public class StringUtils {

    private StringUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static String capitalize(String string) {
        if (string == null || string.isEmpty()) {
            return string;
        }

        char baseChar = string.charAt(0);
        char updatedChar = Character.toUpperCase(baseChar);
        if (baseChar == updatedChar) {
            return string;
        }

        char[] chars = string.toCharArray();
        chars[0] = updatedChar;
        return new String(chars);
    }
}
