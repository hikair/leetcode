package com.tree.middle;

import com.tree.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class CBTInserterTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8),
                                null),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));
        CBTInserter obj = new CBTInserter(root);
        assertEquals(4, obj.insert(9));
    }
}