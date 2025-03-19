package csc223.eh;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinHeapTest {

    @BeforeEach
    public void setUp() {
        MinHeap minHeap = new MinHeap();
    }
    
    
    @Test
    public void testInsert() {

    }

    @Test 
    public void testInsertandPeek() {
        minHeap.insert('B');

        minHeap.insert('A');

        minHeap.insert('C');

        assertEquals('A', minHeap.peek());
    }

    @Test 
    public void testDelete() {
        minHeap.insert('D');

        minHeap.insert('B');

        minHeap.insert('A');

        minHeap.delete();

        assertNotEquals('A', minHeap.peek());

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
