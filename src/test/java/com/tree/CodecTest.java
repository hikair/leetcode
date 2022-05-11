package com.tree;

import org.junit.Test;

public class CodecTest {

    Codec obj = new Codec();

    @Test
    public void serialize() {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(5), new TreeNode(6)), new TreeNode(3, new TreeNode(4), null));
        String serialize = obj.serialize(treeNode);
        System.out.println(serialize);
    }

    @Test
    public void deserialize() {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(5), new TreeNode(6)), new TreeNode(3, new TreeNode(4), null));
        String serialize = obj.serialize(treeNode);
        TreeNode deserialize = obj.deserialize(serialize);
        System.out.println(deserialize);
    }
}