package com.str.simple;

import java.util.Arrays;

/**
 * 2678. 老人的数目
 */
public class CountSeniors {

    public int countSeniors(String[] details) {
        return (int) Arrays.stream(details).mapToInt(e -> (e.charAt(11) - '0') * 10 + (e.charAt(12) - '0')).filter(e -> e > 60).count();
    }
}
