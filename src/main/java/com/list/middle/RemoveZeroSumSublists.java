package com.list.middle;

import com.list.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1171. 从链表中删去总和值为零的连续节点
 * <p>
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 * <p>
 * 删除完毕后，请你返回最终结果链表的头节点。
 * <p>
 *  
 * <p>
 * 你可以返回任何满足题目要求的答案。
 * <p>
 * （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,-3,3,1]
 * 输出：[3,1]
 * 提示：答案 [1,2,1] 也是正确的。
 * 示例 2：
 * <p>
 * 输入：head = [1,2,3,-3,4]
 * 输出：[1,2,4]
 * 示例 3：
 * <p>
 * 输入：head = [1,2,3,-3,-2]
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * <p>
 * 给你的链表中可能有 1 到 1000 个节点。
 * 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-zero-sum-consecutive-nodes-from-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveZeroSumSublists {

    /**
     * 根据前缀和
     * 1, 2, 3, -3, -2, 9
     * 1, 3, 6, 3, 1, 10
     * 第1个节点和第5个节点前缀和相同，那么他们中间节点值加起来必为0，那么只需要将第1个节点的下个节点指向第5个节点的下个节点
     *
     * @param head
     * @return
     */
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int sum = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        for (ListNode temp = dummy; temp != null; temp = temp.next) {
            sum += temp.val;
            map.put(sum, temp);
        }
        sum = 0;
        for (ListNode temp = dummy; temp != null; temp = temp.next) {
            sum += temp.val;
            temp.next = map.get(sum).next;
        }
        return dummy.next;
    }
}
