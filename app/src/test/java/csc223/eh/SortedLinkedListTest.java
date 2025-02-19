package csc223.eh;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SortedLinkedListTest {

    @Test
    public void testInsert() {
        SortedLinkedList sll = new SortedLinkedList();
        sll.insert('A');
        sll.insert('C');
        sll.insert('B');
        sll.insert('X');
        
        String expected = "ABCX";
        assertEquals(expected, sll.toString());

        
    }
}