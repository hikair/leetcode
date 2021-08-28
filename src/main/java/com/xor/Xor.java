package com.xor;

/**
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 *
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 *
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：encoded = [3,1]
 * 输出：[1,2,3]
 * 解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
 * 示例 2：
 *
 * 输入：encoded = [6,5,4,6]
 * 输出：[2,4,1,5,3]
 *  
 *
 * 提示：
 *
 * 3 <= n < 105
 * n 是奇数。
 * encoded.length == n - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-xored-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Xor {

    public int[] decode(int[] encoded) {
        int size = encoded.length + 1;
        int [] result = new int[size];

        for(int i=1;i<=size;i++) {
            for(int j=1;j<=size;j++) {
                if((i ^ j) == encoded[i-1]) {
                    int a = j ^ encoded[i];
                }
            }
        }

        int a = 24;
        int b = a ^ 3;
        int c = b ^ 3;

        System.out.println(c);
        return null;
    }

    public int[] decode1(int[] encoded) {
        int n = encoded.length + 1;
        int[] ans = new int[n];
        // 求得除了 ans[n - 1] 的所有异或结果
        int a = 0;
        for (int i = 0; i < n - 1; i += 2) {
            a ^= encoded[i];
        }
        // 求得 ans 的所有异或结果
        int b = 0;
        for (int i = 1; i <= n; i++) {
            b ^= i;
        }
        // 求得 ans[n - 1] 后，从后往前做
        ans[n - 1] = a ^ b;
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = encoded[i] ^ ans[i + 1];
        }
        return ans;
    }


    public static void main(String[] args) {
        Xor xor = new Xor();
        int[] b = new int[]{6,5,4,6};
        int[] ints = xor.decode1(b);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
