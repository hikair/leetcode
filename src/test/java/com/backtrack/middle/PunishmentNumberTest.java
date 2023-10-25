package com.backtrack.middle;

import org.junit.Test;

import static org.junit.Assert.*;

public class PunishmentNumberTest {

    PunishmentNumber obj = new PunishmentNumber();

    /**
     * 示例 1：
     * <p>
     * 输入：n = 10
     * 输出：182
     * 解释：总共有 3 个整数 i 满足要求：
     * - 1 ，因为 1 * 1 = 1
     * - 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
     * - 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
     * 因此，10 的惩罚数为 1 + 81 + 100 = 182
     * 示例 2：
     * <p>
     * 输入：n = 37
     * 输出：1478
     * 解释：总共有 4 个整数 i 满足要求：
     * - 1 ，因为 1 * 1 = 1
     * - 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
     * - 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
     * - 36 ，因为 36 * 36 = 1296 ，且 1296 可以分割成 1 + 29 + 6 。
     * 因此，37 的惩罚数为 1 + 81 + 100 + 1296 = 1478
     */
    @Test
    public void punishmentNumber() {
        assertEquals(182, obj.punishmentNumber(10));
        assertEquals(1478, obj.punishmentNumber(37));
    }
}