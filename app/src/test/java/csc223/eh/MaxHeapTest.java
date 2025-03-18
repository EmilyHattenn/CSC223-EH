package csc223.eh;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MaxHeapTest {

    @BeforeEach
    void setUp() {
        MaxHeap maxHeap = new MaxHeap();
    }


    @Test
    void testInsert() {
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
    void testDelete() {
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

    }

    @Test 
    void testPeek() {
        

    }

    @Test
    void testSize() {

    }

    @Test 
    void testIsEmpty() {

    }

    @Test 
    void testToString() {

    }
    
}
