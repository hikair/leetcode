package com.num;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 *罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 *
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 *
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 *
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 *
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 15
 * s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
 * 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
 * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
 * IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
 * 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RomanToInt {
    public int romanToInt(String s) {
        Map<String,Integer> map = new HashMap();
        map.put("I",1);
        map.put("II",2);
        map.put("III",3);
        map.put("IV",4);
        map.put("V",5);
        map.put("VI",6);
        map.put("VII",7);
        map.put("VIII",8);
        map.put("IX",9);
        map.put("X",10);
        map.put("XX",20);
        map.put("XXX",30);
        map.put("XL",40);
        map.put("L",50);
        map.put("LX",60);
        map.put("LXX",70);
        map.put("LXXX",80);
        map.put("XC",90);
        map.put("C",100);
        map.put("CC",200);
        map.put("CCC",300);
        map.put("CD",400);
        map.put("D",500);
        map.put("DC",600);
        map.put("DCC",700);
        map.put("DCCC",800);
        map.put("CM",900);
        map.put("M",1000);
        map.put("MM",2000);
        map.put("MMM",3000);

        // 一位罗马数字最长4个字母，最多由2种字母组成
        int left = 0;
        int index = Math.min(4, s.length());
        int sum = 0;

        while(left<s.length()) {
            String str = s.substring(left, index);
            if(map.containsKey(str)) {
                sum += map.get(str);
                left = index;
                index = Math.min(left + 4, s.length());
            }else {
                index--;
            }
        }
        return sum;
    }

    private int getValue2(char c) {
        switch(c) {
            case 'I' :return 1;
            case 'V' :return 5;
            case 'X' :return 10;
            case 'L' :return 50;
            case 'C' :return 100;
            case 'D' :return 500;
            case 'M' :return 1000;
            case 'a' :return 4;
            case 'b' :return 9;
            case 'c' :return 40;
            case 'd' :return 90;
            case 'e' :return 400;
            case 'f' :return 900;
            default:return 0;
        }
    }

    public int romanToInt2(String s) {
        s = s.replace("IV","a");
        s = s.replace("IX","b");
        s = s.replace("XL","c");
        s = s.replace("XC","d");
        s = s.replace("CD","e");
        s = s.replace("CM","f");
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += getValue2(s.charAt(i));
        }
        return sum;
    }

    public int romanToInt3(String s) {
        int sum = 0;
        int v1 = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int v2 = getValue(s.charAt(i));
            if(v1<v2) {
                sum -= v1;
            }else {
                sum += v1;
            }
            v1 = v2;
        }
        sum += v1;
        return sum;
    }

    private int getValue(char c) {
        switch(c) {
            case 'I' :return 1;
            case 'V' :return 5;
            case 'X' :return 10;
            case 'L' :return 50;
            case 'C' :return 100;
            case 'D' :return 500;
            case 'M' :return 1000;
            default:return 0;
        }
    }

    public static void main(String[] args) {
        String s = "CDXLLV";
        RomanToInt romanToInt = new RomanToInt();
        int i = romanToInt.romanToInt3(s);
        System.out.println(i);
    }
}
