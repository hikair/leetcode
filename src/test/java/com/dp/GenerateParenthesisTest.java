package com.dp;

import org.junit.Test;

public class GenerateParenthesisTest {

    GenerateParenthesis obj = new GenerateParenthesis();

    @Test
    public void generateParenthesis() {
        System.out.println(obj.generateParenthesis(2));
        System.out.println(obj.generateParenthesis(3));
        System.out.println(obj.generateParenthesis(4));
    }
}