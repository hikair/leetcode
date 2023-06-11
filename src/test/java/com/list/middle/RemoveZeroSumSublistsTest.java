package com.list.middle;

import com.list.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveZeroSumSublistsTest {

    RemoveZeroSumSublists obj = new RemoveZeroSumSublists();

    @Test
    public void removeZeroSumSublists() {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(-3, new ListNode(-2, new ListNode(9))))));
        obj.removeZeroSumSublists(node);
    }
}