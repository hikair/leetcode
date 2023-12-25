package com.num.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 1276. 不浪费原料的汉堡制作方案
 */
public class NumOfBurgers {

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        int t = tomatoSlices - 2 * cheeseSlices;
        if (t < 0 || t % 2 != 0 || (cheeseSlices - t / 2) < 0) {
            return new ArrayList<>();
        }
        return new ArrayList<Integer>() {
            {
                add(t / 2);
                add(cheeseSlices - t / 2);
            }
        };
    }
}
