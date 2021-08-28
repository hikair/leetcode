package com.dtgh;

/**
 * 你有三种硬币，分别面值2元，5元和7元，每种硬币都有足够的数量
 *
 * 买一本书需要27元
 *
 * 如何用最少的硬币组合正好付清，不需要对方找钱
 */
public class Coin {

    public int minCoinNum(int val) {
        if(val == 0) {
            return 0;
        }

        int res = Integer.MAX_VALUE -1;

        if(val >= 2) {
            res = Math.min(minCoinNum(val - 2) + 1, res);
        }

        if(val >= 5) {
            res = Math.min(minCoinNum(val - 5) + 1, res);
        }

        if(val >= 7) {
            res = Math.min(minCoinNum(val - 7) + 1, res);
        }

        return res;
    }


    /**
     *
     * @param arr 硬币种类 [2,5,7]
     * @param val 钱 27
     * @return
     */
    public int minCoinNum2(int[] arr, int val) {
        int[] f = new int[val + 1];
        f[0] = 0;
        // f[1],f[2],...f[27]  i钱
        for (int i = 1; i < val + 1; i++) {
            f[i] = Integer.MAX_VALUE;
            // 最后一枚硬币arr[j]
            for (int j = 0; j < arr.length; j++) {
                if(i >= arr[j] && f[i-arr[j]] != Integer.MAX_VALUE){
                    f[i] = Math.min(f[i-arr[j]] + 1, f[i]);
                }
            }
        }
        if(f[val] == Integer.MAX_VALUE) {
            return -1;
        }
        return f[val];

    }

    public static void main(String[] args) {

        Coin coin = new Coin();
        int i = coin.minCoinNum2(new int[]{2,5,7},27);
        System.out.println(i);

    }
}
