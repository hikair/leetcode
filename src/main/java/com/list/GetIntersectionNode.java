package com.list;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 *
 *
 *
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * 示例 2：
 *
 *
 *
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Intersected at '2'
 * 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
 * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * 示例 3：
 *
 *
 *
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 这两个链表不相交，因此返回 null 。
 *  
 *
 * 提示：
 *
 * listA 中节点数目为 m
 * listB 中节点数目为 n
 * 0 <= m, n <= 3 * 104
 * 1 <= Node.val <= 105
 * 0 <= skipA <= m
 * 0 <= skipB <= n
 * 如果 listA 和 listB 没有交点，intersectVal 为 0
 * 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1]
 *  
 *
 * 进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetIntersectionNode {

    /**
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t = headA;
        Set set = new HashSet();
        while(t != null) {
            set.add(t);
            t = t.next;
        }
        t = headB;
        while(t != null) {
            if(set.contains(t)) {
                return t;
            }
            t = t.next;
        }
        return null;
    }

    /**
     * pa指向headA，pb指向headB  若pa == null，指向headB；若pb == null，指向headA
     * 设headA和headB相交部分长度为 c ,headA 相交前面的长度为 a ,headB相交前面长度为 b
     * 如果headA和headB长度相同，分为两种情况：1.有相交部分，那么直接返回相交部分 2.无相交部分，pa,pb都指向null 返回null
     * 如果headA和headB长度不相同，分为两种情况：1.有相交部分，pa在走完 a + c + b长度后，pb走完 b + c + a长度，此时pa和pb指向的就是相交的部分
     * 2.无相交部分，m为headA的长度，n为headB的长度 pa,pb都走完m+n后，都为null
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        while(pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }

    public static void main(String[] args) {
        GetIntersectionNode obj = new GetIntersectionNode();
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        node2.next = node1;
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        ListNode headB = new ListNode(3);
        headB.next = node2;
        ListNode headA = new ListNode(0);
        headA.next = node4;
        node4.next = node3;
        node3.next = node2;

        System.out.println(obj.getIntersectionNode2(headA, headB));
    }
}
