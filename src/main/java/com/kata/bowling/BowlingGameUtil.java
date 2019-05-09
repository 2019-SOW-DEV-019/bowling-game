package com.kata.bowling;

public class BowlingGameUtil {

    public static final String REGEX_NUMERIC = "-?\\d+(\\.\\d+)?";

    public static boolean isNumeric(String str) {
        return str.matches(REGEX_NUMERIC);
    }

}
