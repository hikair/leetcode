package com.map.middle;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

@Ignore
public class RemoveSubfoldersTest {

    RemoveSubfolders obj = new RemoveSubfolders();

    @Test
    public void removeSubfolders() {
        assertEquals("[/a, /c/d, /c/f]", obj.removeSubfolders(new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"}).toString());
        assertEquals("[/a]", obj.removeSubfolders(new String[]{"/a","/a/b/c","/a/b/d"}).toString());
        assertEquals("[/a/b/c, /a/b/ca, /a/b/d]", obj.removeSubfolders(new String[]{"/a/b/c","/a/b/ca","/a/b/d"}).toString());
    }
}