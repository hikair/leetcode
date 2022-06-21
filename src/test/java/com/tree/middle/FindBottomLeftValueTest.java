package com.tree.middle;

import com.tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;


public class FindBottomLeftValueTest {

    FindBottomLeftValue obj = new FindBottomLeftValue();

    @Test
    public void findBottomLeftValue() {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        Assert.assertEquals(1, obj.findBottomLeftValue(root));
        root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4), null),
                new TreeNode(3,
                        new TreeNode(5,
                                new TreeNode(7), null),
                        new TreeNode(6)));
        Assert.assertEquals(7, obj.findBottomLeftValue(root));
    }
}