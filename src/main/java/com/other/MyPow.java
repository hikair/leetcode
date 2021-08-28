package com.other;

public class MyPow {
    public double myPow(double x, int n) {
        return Math.pow(x, n);
    }


    /**
     * 暴力法，超时
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, long n) {
        double sum = 1;
        if(n < 0) {
            x = 1 / x;
            n = -n;
        }
        for (int i = 0; i < n; i++) {
            sum *= x;
        }
        return sum;
    }

    public static void main(String[] args) {
        MyPow obj = new MyPow();
        System.out.println(obj.myPow2(2.00,-2));
    }
}
