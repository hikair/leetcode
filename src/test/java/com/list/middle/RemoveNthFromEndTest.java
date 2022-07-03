package com.list.middle;

import com.list.ListNode;
import org.junit.Test;

public class RemoveNthFromEndTest {

    RemoveNthFromEnd obj = new RemoveNthFromEnd();

    @Test
    public void removeNthFromEnd() {
        System.out.println(obj.removeNthFromEnd(new ListNode(1, new ListNode(2)), 2));

        ListNode listNode = obj.removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
        System.out.println(listNode);
        System.out.println(obj.removeNthFromEnd(new ListNode(1), 1));
        System.out.println(obj.removeNthFromEnd(new ListNode(1, new ListNode(2)), 1));
    }
}