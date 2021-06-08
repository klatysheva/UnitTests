package de.telekom.sea.generics;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TogetherTest {
    private Together <String, String> cut;

    @BeforeEach
    void setup() {
        cut = new Together<String, String>("s1", "s2");
    }

    @AfterEach
    void teardown() {
        cut = null;
    }


    @Test
    void getT_test() {
        assertEquals("s1", cut.getT());
    }

    @Test
    void getU_test() {
        assertEquals("s2", cut.getU());
    }

    @Test
    void setT_test() {
        cut.setT("s3");
        assertEquals("s3", cut.getT());
    }

    @Test
    void setU_test() {
        cut.setU("s4");
        assertEquals("s4", cut.getU());
    }

    @Test
    void split_test() {
        cut.split();
        assertEquals(null, cut.getU());
        assertEquals(null, cut.getT());
    }

    @Test
    void join_test() {
        cut.split();
        assertTrue(cut.join("s3", "s4"));
        assertEquals("s3", cut.getT());
        assertEquals("s4", cut.getU());
    }

    @Test
    void equals_Null_test() {
        assertFalse(cut.equals(null));
    }

    @Test
    void equals_TUNull_test() {
        Together<String, String> together = new Together<>();
        assertFalse(cut.equals(together));
    }

    @Test
    void equals_sameTogether_test() {
        Together<String, String> together = cut;
        assertTrue(cut.equals(together));
    }

    @Test
    void equals_TUSwapped_test() {
        Together<String, String> together = new Together<String, String>(cut.getU(), cut.getT());
        assertTrue(cut.equals(together));
    }

    @Test
    void equals_differentU_test() {
        Together<String, String> together = new Together<String, String>(cut.getT(), "difU");
        assertFalse(cut.equals(together));
    }

    @Test
    void equals_differentT_test() {
        Together<String, String> together = new Together<String, String>("difT", cut.getU());
        assertFalse(cut.equals(together));
    }

//    @Test
//    void equals_TDifferentClass_test() {
//        Together<String, String> t = new Together<String, String>();
//        Together<Together, String> together = new Together<Together, String>(t, cut.getU());
//        assertFalse(cut.equals(together));
//    }
//
//    @Test
//    void equals_UDifferentClass_test() {
//        Together<String, String> u = new Together<String, String>();
//        Together<String, Together> together = new Together<String, Together>(cut.getT(), u);
//        assertFalse(cut.equals(together));
//    }


}
