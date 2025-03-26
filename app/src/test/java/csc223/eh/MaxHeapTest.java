package csc223.eh;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MaxHeapTest {

    @BeforeEach
    public void setUp() {
        MaxHeap maxHeap = new MaxHeap();
    }


    @Test
    public void testInsert() {
    
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(7);
        maxHeap.insert(2);
        maxHeap.insert(4);
        maxHeap.insert(6);

        results = maxHeap.toString();
        assertEquals("7, 6, 5, 4, 3, 2", results);
        assertEquals(6, maxHeap.size());

    }

    @Test 
    public void testInsertandPeek() {
        // Test 1
        maxHeap.insert('B');
        maxHeap.insert('A');
        maxHeap.insert('C');

        assertEquals('C', maxHeap.peek());

    }

    @Test 
    public void testDelete() {

        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(7);
        maxHeap.insert(2);
        maxHeap.insert(4);
        maxHeap.insert(6);

        maxHeap.delete();
        results = maxHeap.toString();
        assertEquals("6, 5, 4, 2, 3", results);
        assertEquals(5, maxHeap.size());

        // Test 2
        maxHeap.clear();

    }


    @Test
    public void testSize() {

        assertTrue(maxHeap.isEmpty());

        maxHeap.insert('Z');
        assertEquals(1, maxHeap.size());
        maxHeap.insert('A');
        maxHeap.insert('B');
        assertEquals(3, maxHeap.size());



    }

    @Test 
    public void testIsEmpty() {

        assertTrue(maxHeap.isEmpty());

    }

    @Test 
    public void testToString() {

        assertEquals("[]", maxHeap.toString());

        maxHeap.insert('C');
        maxHeap.insert('A');
        maxHeap.insert('B');

        String expectedMaxHeap = "[C, A, B]"; // Heap property should hold
        assertEquals(expectedMaxHeap, maxHeap.toString());

    }
    
}
