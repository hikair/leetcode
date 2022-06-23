package com.tree.middle;

import com.tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class LargestValuesTest {

    LargestValues obj = new LargestValues();

    @Test
    public void largestValues() {
        TreeNode root = new TreeNode(1,
                new TreeNode(3,
                        new TreeNode(5), new TreeNode(3)),
                new TreeNode(2,
                        null, new TreeNode(9)));
        List<Integer> values = obj.largestValues(root);
        Assert.assertNotNull(values);
        Assert.assertEquals(3, values.size());
        Assert.assertEquals(Integer.valueOf(1), values.get(0));
        Assert.assertEquals(Integer.valueOf(3), values.get(1));
        Assert.assertEquals(Integer.valueOf(9), values.get(2));
    }
}