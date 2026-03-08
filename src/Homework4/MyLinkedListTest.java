package Homework4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedListTest<T> {
    private MyList<String> list;

    @BeforeEach
    void setUp() {
        list = new MyLinkedList<>();
    }

    @Test
    void tesAddAndSize() {
        list.add("пирожок");
        list.add("молоко");
        assertEquals(2, list.size());
    }

    @Test
    void testAddByIndex() {
        list.add("юля");
        list.add("дамир");
        assertEquals("дамир" , list.get(1));
        list.add(1 , "ало");
        assertEquals("ало" , list.get(1));
        assertEquals("дамир" , list.get(2));
    }

    @Test
    void testGet() {
        list.add("java");
        assertEquals("java", list.get(0));
    }

    @Test
    void testRemoveByIndex() {
        list.add("привет");
        list.add("пока");
        list.remove(0);
        assertEquals("пока" , list.get(0));
    }

    @Test
    void testRemoveBoolean() {
        list.add("чай");
        list.add("кофе");
        list.add("боба");
        assertTrue(list.remove("чай"));
        assertFalse(list.remove("матча"));
    }

    @Test
    void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("python");
        assertFalse(list.isEmpty());
    }

    @Test
    void testClear() {
        list.add("кружка");
        list.add("чашка");
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void testContains() {
        list.add("кот");
        assertFalse(list.contains("собака"));
        list.add("собака");
        assertTrue(list.contains("собака"));
    }
    @Test
    void testIndexOf() {
        list.add("боб");
        list.add("стюарт");
        assertEquals(0 , list.indexOf("боб"));
        assertEquals(1 , list.indexOf("стюарт"));
    }
}