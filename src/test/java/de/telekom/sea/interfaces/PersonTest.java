package de.telekom.sea.interfaces;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    private Person cut;

    @BeforeEach
    void setup() {
        cut = new Person("Test person name", "Test person surname");
    }

    @AfterEach
    void teardown() {
        cut = null;
    }

    @Test
    void getName_test() {
        assertEquals("Test person name", cut.getName());
    }

    @Test
    void getSurname_test() {
        assertEquals("Test person surname", cut.getSurname());
    }

    @Test
    void setName_test() {
        cut.setName("New name");
        assertEquals("New name", cut.getName());
    }

    @Test
    void setSurame_test() {
        cut.setSurname("New surname");
        assertEquals("New surname", cut.getSurname());
    }

    @Test
    void equals_null_test() {
        assertFalse(cut.equals(null));
    }

    @Test
    void equals_samePerson_test() {
        assertTrue(cut.equals(cut));
    }

    @Test
    void equals_notPerson_test() {
        String s = new String ("equals_notPerson_test");
        assertFalse(cut.equals(s));
    }

    @Test
    void equals_sameNameSameSurname_test() {
        Person p = new Person("Test person name", "Test person surname");
        assertTrue(cut.equals(p));
    }

    @Test
    void equals_sameNameNotSameSurname_test() {
        Person p = new Person("Test person name", "Test person surname2");
        assertFalse(cut.equals(p));
    }

    @Test
    void equals_notSameNameSameSurname_test() {
        Person p = new Person("Test person name2", "Test person surname");
        assertFalse(cut.equals(p));
    }

}
