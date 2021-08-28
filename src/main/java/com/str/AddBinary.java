package com.str;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();

        StringBuilder sa = new StringBuilder(a);
        StringBuilder sb = new StringBuilder(b);

        if(n >= m) {
            for (int i = 0; i < n - m; i++) {
                sb.insert(0,"0");
            }
        }else {
            for (int i = 0; i < m - n; i++) {
                sa.insert(0,"0");
            }
            n = m;
        }

        StringBuilder res = new StringBuilder();
        m = 0;
        for (int i = n - 1; i >= 0 ; i--) {
            int x = Integer.parseInt(sa.substring(i,i+1));
            int y = Integer.parseInt(sb.substring(i,i+1));
            switch (x+y+m) {
                case 0 : res.insert(0,"0");m = 0;break;
                case 1 : res.insert(0,"1");m = 0;break;
                case 2 : res.insert(0,"0");m = 1;break;
                case 3 : res.insert(0,"1");m = 1;break;
                default:break;
            }
        }

        if(m == 1) {
            res.insert(0,"1");
        }
        return res.toString();
    }

    public String addBinary2(String a, String b) {
        StringBuilder res = new StringBuilder();
        // 是否进位
        int t = 0;
        for (int i = a.length() - 1,j = b.length() - 1; i >= 0 || j >= 0; i--,j--) {
            int sum = t;
            sum += i>=0 ? a.charAt(i) - '0' : 0;
            sum += j>=0 ? b.charAt(j) - '0' : 0;
            res.insert(0,sum%2);
            t = sum / 2;
        }
        if(t == 1) {
            res.insert(0,1);
        }
        return res.toString();
    }

    public String addBinary3(String a, String b) {
        StringBuilder res = new StringBuilder();
        // 是否进位
        int t = 0;
        for (int i = a.length() - 1,j = b.length() - 1; i >= 0 || j >= 0; i--,j--) {
            int sum = t;
            sum += i>=0 ? a.charAt(i) - '0' : 0;
            sum += j>=0 ? b.charAt(j) - '0' : 0;
            res.append(sum%2);
            t = sum / 2;
        }
        if(t == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary2("1010","1011"));
        System.out.println(addBinary.addBinary3("0","0"));
    }
}
