package csc223.eh;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class DoublyLinkedListTest {

    @Test
    public void testInsert() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert('A');
        list.insert('B');
        list.insert('C');

        assertEquals(3, list.size(), "Size should be 3 after inserting three elements.");
        assertEquals('A', list.getFirst(), "First element should be 'A'.");
        assertEquals('C', list.getLast(), "Last element should be 'C'.");
        assertEquals("ABC", list.toString(), "List should be 'ABC'.");
    }

    @Test
    public void testRemoveHead() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert('A');
        list.insert('B');
        list.insert('C');

        list.remove('A'); // Remove the head

        assertEquals(2, list.size(), "Size should be 2 after removing the head.");
        assertEquals('B', list.getFirst(), "First element should now be 'B'.");
        assertEquals("BC", list.toString(), "List should be 'BC'.");
    }

    @Test
    public void testRemoveMiddle() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert('A');
        list.insert('B');
        list.insert('C');

        list.remove('B'); // Remove the middle element

        assertEquals(2, list.size(), "Size should be 2 after removing a middle element.");
        assertFalse(list.contains('B'), "List should not contain 'B'.");
        assertEquals("AC", list.toString(), "List should be 'AC'.");
    }

    @Test
    public void testRemoveTail() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert('A');
        list.insert('B');
        list.insert('C');

        list.remove('C'); // Remove the tail

        assertEquals(2, list.size(), "Size should be 2 after removing the tail.");
        assertEquals('B', list.getLast(), "Last element should now be 'B'.");
        assertEquals("AB", list.toString(), "List should be 'AB'.");
    }

    @Test
    public void testRemoveNonExistentElement() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert('A');
        list.insert('B');
        list.insert('C');

        list.remove('X'); // Attempt to remove a non-existent element

        assertEquals(3, list.size(), "Size should remain 3 as 'X' is not in the list.");
        assertEquals("ABC", list.toString(), "List should remain unchanged.");
    }

    @Test
    public void testEmptyList() {
        DoublyLinkedList list = new DoublyLinkedList();

        assertEquals(0, list.size());
        assertEquals('x', list.getFirst());
        assertEquals('x', list.getLast());
    }
}
