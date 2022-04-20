package com.stack;

import org.junit.Assert;
import org.junit.Test;


public class LengthLongestPathTest {

    LengthLongestPath obj = new LengthLongestPath();

    @Test
    public void lengthLongestPath() {
        String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        Assert.assertEquals(20, obj.lengthLongestPath(input));
        input = "a";
        Assert.assertEquals(0, obj.lengthLongestPath(input));
        input = "file1.txt\nfile2.txt\nlongfile.txt";
        Assert.assertEquals(12, obj.lengthLongestPath(input));
        String in = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        obj.lengthLongestPath(in);
        in = "dir\n        file.txt";
        Assert.assertEquals(16, obj.lengthLongestPath(in));
    }

}