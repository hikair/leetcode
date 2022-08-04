package com.tree.middle;

import com.tree.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddOneRowTest {

    AddOneRow obj = new AddOneRow();

    @Test
    public void addOneRow() {
        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(3), new TreeNode(1)),
                new TreeNode(6, new TreeNode(5), null));
        TreeNode node = obj.addOneRow(root, 1, 2);
        System.out.println(node);
    }
}