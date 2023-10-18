package com.queue.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxKelementsTest {

    MaxKelements obj = new MaxKelements();

    /**
     * 输入：nums = [1,10,3,3,3], k = 3
     * 输出：17
     * 解释：可以执行下述操作：
     * 第 1 步操作：选中 i = 1 ，nums 变为 [1,4,3,3,3] 。分数增加 10 。
     * 第 2 步操作：选中 i = 1 ，nums 变为 [1,2,3,3,3] 。分数增加 4 。
     * 第 3 步操作：选中 i = 2 ，nums 变为 [1,1,1,3,3] 。分数增加 3 。
     * 最后分数是 10 + 4 + 3 = 17 。
     */
    @Test
    public void maxKelements() {
        assertEquals(17L, obj.maxKelements(new int[]{1, 10, 3, 3, 3}, 3));
    }
}