package com.backtrack.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 *
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 20
 * s 仅由数字组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RestoreIpAddresses {

    private List<String> result;

    private List<String> path;

    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        backtracking(s, 0, 0);
        return result;
    }

    /**
     *
     * @param s
     * @param segId 当前搜索第几个片段
     * @param start 从哪个下标开始
     */
    private void backtracking(String s, int segId, int start) {
        if (path.size() == 4) {
            result.add(String.join(".", path));
            return;
        }
        for (int i = 1; i < 4; i++) {
            // 长度校验
            int leave = s.length() - start - i;
            if (leave < 0) {
                break;
            }
            if ((3 - segId) * 3 < leave) {
                continue;
            }
            String temp = s.substring(start, start + i);
            // 前导0校验
            if (temp.startsWith("0") && temp.length() > 1) {
                break;
            }
            if (Integer.parseInt(temp) > 255) {
                continue;
            }
            path.add(temp);
            backtracking(s, segId + 1, start + i);
            path.remove(path.size() - 1);
        }
    }
}
