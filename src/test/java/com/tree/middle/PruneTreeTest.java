package com.tree.middle;

import com.tree.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class PruneTreeTest {

    PruneTree obj = new PruneTree();

    @Test
    public void pruneTree() {
        TreeNode node1 = new TreeNode(1,
                null,
                new TreeNode(0,
                        new TreeNode(0),
                        new TreeNode(1)));
        System.out.println(obj.pruneTree(node1));

        TreeNode node2 = new TreeNode(1,
                new TreeNode(0,
                        new TreeNode(0),
                        new TreeNode(0)),
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(1)));
        System.out.println(obj.pruneTree(node2));

        TreeNode node3 = new TreeNode(0);
        System.out.println(obj.pruneTree(node3));
    }
}