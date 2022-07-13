package com.map.hard;

import java.util.HashMap;
import java.util.Map;

public class WordFilter {

    Map<String, Integer> dict = new HashMap<>();

    public WordFilter(String[] words) {
        buildDict(words);
    }

    public int f(String pref, String suff) {
        return dict.getOrDefault(String.format("%s#%s", pref, suff), -1);
    }

    private void buildDict(String[] words) {
        int n = words.length;
        for (int i = 0; i < n; i++) {
            int m = words[i].length();
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= m; k++) {
                    dict.put(String.format("%s#%s", words[i].substring(0, j), words[i].substring(m - k)), i);
                }
            }
        }
    }
}
