package com.str.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 2103. 环和杆
 */
public class CountPoints {

    public int countPoints(String rings) {
        int n = rings.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 1; i < n; i = i + 2) {
            int x = map.getOrDefault(rings.charAt(i), 0);
            if (x == 7) {
                continue;
            }
            x |= getY(rings.charAt(i - 1));
            if (x == 7) {
                ans++;
            }
            map.put(rings.charAt(i), x);
        }
        return ans;
    }

    private int getY(Character c) {
        if (c == 'R') {
            return 1;
        }
        if (c == 'B') {
            return 2;
        }
        return 4;
    }
}
