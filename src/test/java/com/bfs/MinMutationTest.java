package com.bfs;

import org.junit.Assert;
import org.junit.Test;

public class MinMutationTest {

    MinMutation obj = new MinMutation();

    @Test
    public void minMutation() {
        Assert.assertEquals(-1, obj.minMutation("AACCGGTA", "AACCGGTT", new String[]{"AACCGGTA"}));
        Assert.assertEquals(0, obj.minMutation("AACCGGTA", "AACCGGTA", new String[]{"AACCGGTA"}));
        Assert.assertEquals(1, obj.minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
        Assert.assertEquals(2, obj.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
        Assert.assertEquals(3, obj.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
    }
}