package com.dfs;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LexicalOrderTest {

    LexicalOrder obj = new LexicalOrder();

    @Test
    public void lexicalOrder() {
        List<Integer> ans = obj.lexicalOrder(13);
        System.out.println(ans);
        ans = obj.lexicalOrder(1000);
        System.out.println(ans);
    }
}