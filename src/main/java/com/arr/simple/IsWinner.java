package com.arr.simple;

/**
 * 2660. 保龄球游戏的获胜者
 */
public class IsWinner {

    public int isWinner(int[] player1, int[] player2) {
        int t = getScore(player1) - getScore(player2);
        return t == 0 ? 0 : (t > 0 ? 1 : 2);
    }

    private int getScore(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i > 1) {
                if (arr[i - 1] == 10 || arr[i - 2] == 10) {
                    sum += arr[i] * 2;
                    continue;
                }
            } else if (i == 1) {
                if (arr[i - 1] == 10) {
                    sum += arr[i] * 2;
                    continue;
                }
            }
            sum += arr[i];
        }
        return sum;
    }
}