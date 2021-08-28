package com.num;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 整数转罗马数字
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
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
 * 给你一个整数，将其转为罗马数字。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: num = 3
 * 输出: "III"
 * 示例 2:
 *
 * 输入: num = 4
 * 输出: "IV"
 * 示例 3:
 *
 * 输入: num = 9
 * 输出: "IX"
 * 示例 4:
 *
 * 输入: num = 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 *
 * 输入: num = 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *  
 *
 * 提示：
 *
 * 1 <= num <= 3999
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntToRoman {

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        Map<Integer,String> map = new HashMap();
        map.put(1,"I");
        map.put(5,"V");
        map.put(10,"X");
        map.put(50,"L");
        map.put(100,"C");
        map.put(500,"D");
        map.put(1000,"M");

        // 获取每位的数字 个 十 百 千
        List<Integer> list = new ArrayList<Integer>();
        while(num>0) {
            list.add(num%10);
            num /= 10;
        }

        for (int i = 0; i < list.size(); i++) {
            // 当前位的值
            int value = list.get(i);
            // 当前位 1 10 100 1000
            int bit = (int)Math.pow(10,i);

            if(value == 4 || value == 9) {
                sb.insert(0,map.get(bit)+map.get((value+1)*bit));
            } else if(value < 4){
                // 插入等量数量的1
                while(value > 0) {
                    sb.insert(0,map.get(bit));
                    value--;
                }
            } else {
                // 先插入-5数量的1
                while(value > 5) {
                    sb.insert(0,map.get(bit));
                    value--;
                }
                // 再插入5
                sb.insert(0,map.get(5*bit));
            }
        }
        return sb.toString();
    }

    public String intToRoman2(int num) {
        String[] one = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String[] ten = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] hundred = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] thousand = {"","M","MM","MMM"};
        return thousand[num / 1000] + hundred[num / 100 % 10] + ten[num / 10 % 10] + one[num % 10];
    }

    public static void main(String[] args) {
        IntToRoman intToRoman = new IntToRoman();
        String s = intToRoman.intToRoman2(444);
        System.out.println(s);
    }
}
