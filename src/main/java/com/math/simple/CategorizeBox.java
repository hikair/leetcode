package com.math.simple;

/**
 * 2525. 根据规则将箱子分类
 */
public class CategorizeBox {

    public String categorizeBox(int length, int width, int height, int mass) {
        int t = isHeavy(mass) + isBulky(length, width, height);
        switch (t) {
            case 0: return "Neither";
            case 1: return "Heavy";
            case 2: return "Bulky";
            case 3: return "Both";
        }
        return null;
    }

    private int isHeavy(int mass) {
        return mass >= 100 ? 1 : 0;
    }

    private int isBulky(int length, int width, int height) {
        if (length >= 10000 || width >= 10000 || height >= 10000 || ((long) length * width * height) >= 1000000000) {
            return 2;
        }
        return 0;
    }
}
