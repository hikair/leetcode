package com.str.simple;

public class CountTime {

    public int countTime(String time) {
        if (!time.contains("?")) {
            return 1;
        }
        char[] cs = time.toCharArray();
        int count = 1;
        if (cs[0] == '?' && cs[1] == '?') {
            count *= 24;
        } else {
            if (cs[0] == '?') {
                if (cs[1] - '0' > 3) {
                    count *= 2;
                } else {
                    count *= 3;
                }
            }
            if (cs[1] == '?') {
                if (cs[0] == '2') {
                    count *= 4;
                } else {
                    count *= 10;
                }
            }
        }
        if (cs[3] == '?') {
            count *= 6;
        }
        if (cs[4] == '?') {
            count *= 10;
        }
        return count;
    }
}
