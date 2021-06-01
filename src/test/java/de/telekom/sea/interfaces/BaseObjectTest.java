package de.telekom.sea.interfaces;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BaseObjectTest {
    private BaseObject cut;

    @BeforeEach
    void setup() {
        cut = new BaseObject();
    }

    @AfterEach
    void teardown() {
        cut = null;
    }

    @Test
    void getId_test() {
        assertEquals(1, cut.getId());
    }

    @Test
    void setId_test() {
        cut.setId(65);
        assertEquals(65, cut.getId());
    }

    @Test
    void toString_test() {
        cut.setId(6895);
        assertEquals("6895", cut.toString());
    }

    @Test
    void equals_null_test() {
        assertFalse(cut.equals(null));
    }

    @Test
    void equals_sameObject_test() {
        assertTrue(cut.equals(cut));
    }

    @Test
    void equals_notObject_test() {
        int i = 3;
        assertFalse(cut.equals(i));
    }

    @Test
    void equals_equalIds_test() {
        BaseObject bo = new BaseObject();
        bo.setId(cut.getId());
        assertTrue(cut.equals(bo));
    }

    @Test
    void getParent_test() {
        assertEquals(null, cut.getParent());
    }

    @Test
    void setParent_test() {
        Object parent = new Object();
        cut.setParent(parent);
        assertEquals(parent, cut.getParent());
    }

}
