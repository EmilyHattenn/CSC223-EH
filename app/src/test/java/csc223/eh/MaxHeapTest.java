package csc223.eh;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

        // Test 2

    }

    @Test 
    public void testDelete() {
        // Test 1
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

    }

    @Test 
    public void testPeek() {
        

    }

    @Test
    public void testSize() {

    }

    @Test 
    public void testIsEmpty() {

    }

    @Test 
    public void testToString() {

    }
    
}
