package com.hash;

import org.junit.Test;

public class GroupAnagramsTest {

    GroupAnagrams obj = new GroupAnagrams();

    @Test
    public void groupAnagrams() {
        System.out.println(obj.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(obj.groupAnagrams(new String[]{""}));
        System.out.println(obj.groupAnagrams(new String[]{"a"}));
    }
}