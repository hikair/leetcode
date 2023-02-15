package com.math.hard;

public class IsGoodArray {
    public boolean isGoodArray(int[] nums) {
        int t = nums[0];
        for (int i = 1; i < nums.length; i++) {
            t = gcd(t, nums[i]);
            if (t == 1) {
                return true;
            }
        }
        return t == 1;
    }

    public int gcd(int n1, int n2) {
        while(n2 != 0) {
            int t = n1;
            n1 = n2;
            n2 = t % n1;
        }
        return n1;
    }
}
