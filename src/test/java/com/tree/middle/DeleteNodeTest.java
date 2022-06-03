package com.tree.middle;

import com.tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;


public class DeleteNodeTest {

    DeleteNode obj = new DeleteNode();

    @Test
    public void deleteNode() {
        TreeNode root = new TreeNode(0);
        TreeNode node = obj.deleteNode(root, 0);
        Assert.assertNull(node);

        node = obj.deleteNode(getTestTreeNode(), 3);
        Assert.assertEquals(2, node.left.val);
        Assert.assertEquals(4, node.left.right.val);
        Assert.assertEquals(6, node.right.val);
        Assert.assertEquals(7, node.right.right.val);
        Assert.assertNull(node.left.left);

        node = obj.deleteNode(getTestTreeNode(), 5);
        Assert.assertEquals(4, node.val);
        Assert.assertEquals(3, node.left.val);
        Assert.assertEquals(2, node.left.left.val);
        Assert.assertEquals(6, node.right.val);
        Assert.assertEquals(7, node.right.right.val);
        Assert.assertNull(node.left.right);

        root = getTestTreeNode();
        node = obj.deleteNode(root, 0);
        Assert.assertSame(root, node);

        root = new TreeNode(1, null, new TreeNode(2));
        node = obj.deleteNode(root, 1);
        Assert.assertEquals(2, node.val);
        Assert.assertNull(node.right);
    }

    private TreeNode getTestTreeNode() {
        return new TreeNode(5,
                new TreeNode(3, new TreeNode(2), new TreeNode(4)),
                new TreeNode(6, null, new TreeNode(7)));
    }
}