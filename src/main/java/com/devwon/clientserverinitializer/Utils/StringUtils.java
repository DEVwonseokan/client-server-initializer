package com.devwon.clientserverinitializer.Utils;

public class StringUtils {
    public static String padLeft(String s, int n) {
        return String.format("%0" + n + "d", Integer.parseInt(s));
    }
}
