package com.list;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 *
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 列表中的节点在范围 [0, 10^4] 内
 * 1 <= Node.val <= 50
 * 0 <= k <= 50
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-linked-list-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = new ListNode(-1);
        ListNode temp = prev;

        while(head != null) {
            if(head.val != val) {
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

    public ListNode removeElements2(ListNode head, int val) {
        ListNode prev = new ListNode(-1);
        ListNode temp = prev;
        temp.next = head;

        while(temp.next != null) {
            if(temp.next.val == val) {
                temp.next = temp.next.next;
            }else {
                temp = temp.next;
            }
        }
        return prev.next;
    }

    public static void main(String[] args) {
        RemoveElements obj = new RemoveElements();
        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(6);
        ListNode node1 = new ListNode(2);
        ListNode head = new ListNode(1,node1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        System.out.println(obj.removeElements2(head, 6));

/*        ListNode node6 = new ListNode(7);
        ListNode node5 = new ListNode(7);
        ListNode node4 = new ListNode(7);
        ListNode node3 = new ListNode(6);
        ListNode node2 = new ListNode(7);
        ListNode node1 = new ListNode(7);
        ListNode head = new ListNode(7,node1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        System.out.println(obj.removeElements2(head, 7));*/
    }
}
