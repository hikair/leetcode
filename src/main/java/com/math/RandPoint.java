package com.math;

import java.util.Random;

/**
 * 给定圆的半径和圆心的位置，实现函数 randPoint ，在圆中产生均匀随机点。
 * <p>
 * 实现 Solution 类:
 * <p>
 * Solution(double radius, double x_center, double y_center) 用圆的半径 radius 和圆心的位置 (x_center, y_center) 初始化对象
 * randPoint() 返回圆内的一个随机点。圆周上的一点被认为在圆内。答案作为数组返回 [x, y] 。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * ["Solution","randPoint","randPoint","randPoint"]
 * [[1.0, 0.0, 0.0], [], [], []]
 * 输出: [null, [-0.02493, -0.38077], [0.82314, 0.38945], [0.36572, 0.17248]]
 * 解释:
 * Solution solution = new Solution(1.0, 0.0, 0.0);
 * solution.randPoint ();//返回[-0.02493，-0.38077]
 * solution.randPoint ();//返回[0.82314,0.38945]
 * solution.randPoint ();//返回[0.36572,0.17248]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 < radius <= 10^8
 * -10^7 <= x_center, y_center <= 10^7
 * randPoint 最多被调用 3 * 104 次
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/generate-random-point-in-a-circle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RandPoint {

    Random random;
    double r;
    double rx;
    double ry;

    public RandPoint(double radius, double x_center, double y_center) {
        this.random = new Random();
        this.r = radius;
        this.rx = x_center;
        this.ry = y_center;
    }

    public double[] randPoint() {
        while (true) {
            double x = random.nextDouble() * 2 * r - r;
            double y = random.nextDouble() * 2 * r - r;
            if (x * x + y * y <= r * r) {
                return new double[]{x + rx, y + ry};
            }
        }
    }
}
