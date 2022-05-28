package com.stack.simple;

import org.junit.Assert;
import org.junit.Test;


public class RemoveOuterParenthesesTest {

    RemoveOuterParentheses obj = new RemoveOuterParentheses();

    @Test
    public void removeOuterParentheses() {
        Assert.assertEquals("()()()", obj.removeOuterParentheses("(()())(())"));
        Assert.assertEquals("()()()()(())", obj.removeOuterParentheses("(()())(())(()(()))"));
        Assert.assertEquals("", obj.removeOuterParentheses("()()"));
    }
}