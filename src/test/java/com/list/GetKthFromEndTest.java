package com.list;

import org.junit.Before;
import org.junit.Test;

public class GetKthFromEndTest {

    GetKthFromEnd obj;

    @Before
    public void init() {
        obj = new GetKthFromEnd();
    }

    @Test
    public void getKthFromEnd() {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode kthFromEnd = obj.getKthFromEnd(listNode, 2);
        System.out.println(kthFromEnd);
    }
}