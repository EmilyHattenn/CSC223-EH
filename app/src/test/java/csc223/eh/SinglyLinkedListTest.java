package csc223.eh;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


public class SinglyLinkedListTest {

    @Test
    public void testInsert() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert('A');
        list.insert('B');
        list.insert('C');

        assertEquals(3, list.size());
        assertEquals('A', list.getFirst());
        assertEquals('C', list.getLast());
        assertEquals("ABC", list.toString());
    }

    @Test
    public void testRemove() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert('A');
        list.insert('B');
        list.insert('C');

        list.remove('B');
        assertEquals(2, list.size());
        assertFalse(list.contains('B'));
        assertEquals("AC", list.toString());

        list.remove('A');
        assertEquals(1, list.size());
        assertEquals('C', list.getFirst());

          // Ensures '☠' is returned
    }

    @Test
    public void testGetFirstAndLast() {
        SinglyLinkedList list = new SinglyLinkedList();
        assertEquals('x', list.getFirst());  // Empty list case

        list.insert('X');
        assertEquals('X', list.getFirst());
        assertEquals('X', list.getLast());
    }

    @Test
    public void testGetByIndex() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert('A');
        list.insert('B');
        list.insert('C');

        assertEquals('A', list.get(0));
        assertEquals('B', list.get(1));
        assertEquals('C', list.get(2));
        assertEquals('x', list.get(5)); // Out of bounds
    }

    @Test
    public void testIsEmpty() {
        SinglyLinkedList list = new SinglyLinkedList();
        assertTrue(list.isEmpty());

        list.insert('A');
        assertFalse(list.isEmpty());
    }

    @Test
    public void testClear() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert('A');
        list.insert('B');
        list.clear();

        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        assertEquals('x', list.getFirst());
    }

    @Test
    public void testContains() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert('A');
        list.insert('B');

        assertTrue(list.contains('A'));
        assertFalse(list.contains('Z'));
    }

    @Test
    public void testIndexOf() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert('A');
        list.insert('B');
        list.insert('C');
        list.insert('B');

        assertEquals(1, list.indexOf('B'));
        assertEquals(3, list.lastIndexOf('B'));
        assertEquals(-1, list.indexOf('Z'));
    }

    @Test
    public void testReverse() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert('A');
        list.insert('B');
        list.insert('C');

        list.reverse();
        assertEquals("CBA", list.toString());
    }

    @Test
    public void testToString() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert('A');
        list.insert('B');
        list.insert('C');

        assertEquals("ABC", list.toString());
    }
}
