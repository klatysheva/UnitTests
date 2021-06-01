package de.telekom.sea.interfaces;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParticipantGroupTest {

    private ParticipantGroup cut;

    @BeforeEach
    void setup() {
        cut = new ParticipantGroup(2);
    }


    @Test
    void size_test() {
        assertEquals(0, cut.size());
        Person person = new Person("size_notZero_test name", "size_notZero_test surname");
        Person person1 = new Person("size_notZero_test name", "size_notZero_test surname");
        cut.add(person);
        assertEquals(1, cut.size());
        cut.add(person1);
        assertEquals(2, cut.size());
    }

    @Test
    void add_positive_test() {
        Person person = new Person("add_test name", "add_test surname");
        boolean result = cut.add(person);
        assertTrue(result);
        int size = cut.size();
        assertEquals(1, size);
    }

    @Test
    void add_null_test() {
        int size = cut.size();
        boolean result = cut.add(null);
        assertFalse(result);
        assertEquals(cut.size(), size);
    }

    @Test
    void add_noPlaces_test1() {
        //preconditions (array [2], 2 places occupied):
        Person person1 = new Person("add_noPlaces_test name", "add_noPlaces_test surname");
        Person person2 = new Person("add_noPlaces_test name", "add_noPlaces_test surname");
        Person person3 = new Person("add_noPlaces_test name", "add_noPlaces_test surname");
        cut.add(person1);
        cut.add(person2);

        assertEquals(RuntimeException.class, noPlacesException(person3).getClass());
    }

    @Test
    void add_noPlaces_test2() {
        //preconditions (array [2], 2 places occupied):
        Person person1 = new Person("add_noPlaces_test name", "add_noPlaces_test surname");
        Person person2 = new Person("add_noPlaces_test name", "add_noPlaces_test surname");
        Person person3 = new Person("add_noPlaces_test name", "add_noPlaces_test surname");
        cut.add(person1);
        cut.add(person2);

        boolean result;
        try {
            result = cut.add(person3);
        } catch (RuntimeException rte) {
            result = false;
        }
        assertFalse(result);
    }

    @Test
    void add_noPlaces_test3() {
        //preconditions (array [2], 2 places occupied):
        Person person1 = new Person("add_noPlaces_test name", "add_noPlaces_test surname");
        Person person2 = new Person("add_noPlaces_test name", "add_noPlaces_test surname");
        Person person3 = new Person("add_noPlaces_test name", "add_noPlaces_test surname");
        cut.add(person1);
        cut.add(person2);

        assertThrows(RuntimeException.class,
                () -> {
                    cut.add(person3);
                });
    }

    RuntimeException noPlacesException(Person person) {
        try {
            cut.add(person);
        } catch (RuntimeException rte) {
            return rte;
        }
        return null;
    }

    @Test
    void add_notPerson_test() {
        String stringPerson = new String("add_notPerson_test");
        assertFalse(cut.add(stringPerson));

    }

    @Test
    void add_theSamePerson_test() {
        Person person1 = new Person("add_noPlaces_test name", "add_noPlaces_test surname");
        cut.add(person1);
        assertFalse(cut.add(person1));
    }

    @Test
    void clear_test() {
        Person person = new Person("clear_test name", "clear_test surname");
        cut.add(person);
        int size = cut.size();
        assertNotEquals(0, size);
        cut.clear();
        size = cut.size();
        assertEquals(0, size);
    }

    @Test
    void search_onePerson_test() {
        Person person = new Person("search_test name", "search_test surname");
        Person person1 = new Person("search_test name", "search_test surname2");
        cut.add(person);
        cut.add(person1);
        MyList result = cut.search("search_test surname2");
        assertEquals(1, result.size());
    }


    @Test
    void search_twoPersons_test() {
        Person person = new Person("search_twoPersons_test name", "search_twoPersons_test surname1");
        Person person1 = new Person("search_twoPersons_test name", "search_twoPersons_test surname2");
        cut.add(person);
        cut.add(person1);
        MyList result = cut.search("search_twoPersons_test");
        assertEquals(2, result.size());
    }

    @Test
    void get_test() {
        Person person = new Person("get_test name", "get_test surname");
        cut.add(person);
        Person result = cut.get(0);
        assertNotNull(result);
        assertSame(result, person);
    }

    @Test
    void get_null_test() {
        assertNull(cut.get(0));
    }

    @Test
    void get_RuntimeException_test() {
        assertThrows(RuntimeException.class,
                () -> {
                    cut.get(-1);
                });
    }

    @Test
    void remove_null_test() {
        assertFalse(cut.remove(null));
    }

    @Test
    void remove_notPerson_test() {
        //preconditions:
        String stringPerson = new String("add_notPerson_test");

        assertFalse(cut.remove(stringPerson));
    }

    @Test
    void remove_positive_test() {
        //preconditions:
        Person person = new Person("remove_positive_test name1", "remove_positive_test surname1");
        Person person1 = new Person("remove_positive_test name2", "remove_positive_test surname2");
        cut.add(person);
        cut.add(person1);
        assertEquals(2, cut.size());
        assertEquals(1, cut.search("remove_positive_test surname1").size());

        assertTrue(cut.remove(person));
        assertEquals(1, cut.size());
        assertEquals(0, cut.search("remove_positive_test surname1").size());
    }

    @Test
    void remove_personNotInTheList_test() {
        //preconditions:
        Person person = new Person("remove_positive_test name1", "remove_positive_test surname1");
        Person person1 = new Person("remove_positive_test name2", "remove_positive_test surname2");
        cut.add(person);

        assertFalse(cut.remove(person1));
        assertEquals(1, cut.size());
        assertEquals(1, cut.search("remove_positive_test surname1").size());
    }

    @AfterEach
    void teardown() {
        cut = null;
    }
}
