package com.hash.middle;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

@Ignore
public class AlertNamesTest {

    AlertNames obj = new AlertNames();

    @Test
    public void alertNames() {
        assertEquals("[daniel]", obj.alertNames(new String[]{"daniel","daniel","daniel","luis","luis","luis","luis"}, new String[]{"10:00","10:40","11:00","09:00","11:00","13:00","15:00"}).toString());
        assertEquals("[bob]", obj.alertNames(new String[]{"alice","alice","alice","bob","bob","bob","bob"}, new String[]{"12:01","12:00","18:00","21:00","21:20","21:30","23:00"}).toString());
        assertEquals("[]", obj.alertNames(new String[]{"john","john","john"}, new String[]{"23:58","23:59","00:01"}).toString());
        assertEquals("[clare, leslie]", obj.alertNames(new String[]{"leslie","leslie","leslie","clare","clare","clare","clare"}, new String[]{"13:00","13:20","14:00","18:00","18:51","19:30","19:49"}).toString());
    }
}