package com.tree.middle;

import com.tree.TreeNode;
import org.junit.Test;

import java.util.Arrays;


public class FindFrequentTreeSumTest {

    FindFrequentTreeSum obj = new FindFrequentTreeSum();

    @Test
    public void findFrequentTreeSum() {
        TreeNode root = new TreeNode(5, new TreeNode(2), new TreeNode(-3));
        System.out.println(Arrays.toString(obj.findFrequentTreeSum(root))); // 2, -3, 4
        root = new TreeNode(5, new TreeNode(2), new TreeNode(-5));
        System.out.println(Arrays.toString(obj.findFrequentTreeSum(root))); // 2
    }
}