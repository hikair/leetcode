package com.dtgh;

/**
 * 给定m行n列的网格，有一个机器人从左上角(0,0)出发，每一步可以向下或者向右走一步
 * 问有多少种不同的方式 走到右下角
 */
public class Robot {

    public int unquePaths(int m, int n) {
        // m行，n列
        int[][] f = new int[m][n];

        // 初始条件
        f[0][0] = 1;

        // 遍历行
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 第0行或者第0列只有一种解法
                if(i==0 || j==0) {
                    f[i][j] = 1;
                }else {
                    f[i][j] = f[i-1][j] + f[i][j-1];
                }
            }
        }
        return f[m-1][n-1];
    }

    public static void main(String[] args) {
        Robot robot = new Robot();
        int i = robot.unquePaths(10, 10);
        System.out.println(i);
    }
}
