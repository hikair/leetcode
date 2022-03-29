package com.dp;

public class CanJump {

    public boolean canJump(int[] a) {

        boolean[] f = new boolean[a.length];
        f[0] = true;

        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if(f[j] && a[j]+j >= i) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[a.length -1];
    }

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        System.out.println(canJump.canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump.canJump(new int[]{3,2,1,0,4}));
    }
}
