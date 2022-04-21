package com.str;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ToGoatLatinTest {

    ToGoatLatin obj = new ToGoatLatin();

    @Test
    public void toGoatLatin() {
        Assert.assertEquals("imaa", obj.toGoatLatin("i"));
        Assert.assertEquals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa", obj.toGoatLatin("I speak Goat Latin"));
        Assert.assertEquals("heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa", obj.toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }
}