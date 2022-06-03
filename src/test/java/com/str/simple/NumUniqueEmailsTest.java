package com.str.simple;

import org.junit.Assert;
import org.junit.Test;


public class NumUniqueEmailsTest {

    NumUniqueEmails obj = new NumUniqueEmails();

    @Test
    public void numUniqueEmails() {
        String[] emails = new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        Assert.assertEquals(2, obj.numUniqueEmails(emails));
        emails = new String[]{"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
        Assert.assertEquals(3, obj.numUniqueEmails(emails));
    }
}