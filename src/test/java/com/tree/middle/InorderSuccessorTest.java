package com.tree.middle;

import com.tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;


public class InorderSuccessorTest {

    InorderSuccessor obj = new InorderSuccessor();

    @Test
    public void inorderSuccessor() {
        TreeNode node = new TreeNode(2, null, new TreeNode(3));
        TreeNode treeNode = obj.inorderSuccessor(node, node);
        Assert.assertEquals(3, treeNode.val);
        // [5,3,6,1,4,null,null,null,2] 4 -> 5
    }
}