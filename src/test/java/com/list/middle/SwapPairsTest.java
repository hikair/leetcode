package com.list.middle;

import com.list.ListNode;
import org.junit.Test;

public class SwapPairsTest {

    SwapPairs obj = new SwapPairs();

    @Test
    public void swapPairs() {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6,
                                                        new ListNode(7,
                                                                new ListNode(8,
                                                                        new ListNode(9)))))))));
        ListNode temp = obj.swapPairs(head);
        System.out.println(temp);
    }
}