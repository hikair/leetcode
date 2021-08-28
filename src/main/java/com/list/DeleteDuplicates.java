package com.list;

/**
 *存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 *
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 *
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *  
 *
 * 提示：
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = new ListNode(101);
        ListNode temp = prev;
        while(head != null) {
            if(temp.val != head.val) {
                temp.next = head;
                temp = temp.next;
            }
            head = head.next;
            if(head == null) {
                temp.next = null;
            }
        }
        return prev.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode node = head;
        while(node != null && node.next != null) {
            if(node.val == node.next.val) {
                node.next = node.next.next;
            }else {
                node = node.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        System.out.println(deleteDuplicates.deleteDuplicates2(new ListNode(1,new ListNode(1,new ListNode(1)))));
        System.out.println(deleteDuplicates.deleteDuplicates2(new ListNode(1,new ListNode(2,new ListNode(2,new ListNode(4))))));
        System.out.println(deleteDuplicates.deleteDuplicates2(new ListNode(1,new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(3)))))));
    }
}
