package csc223.eh;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MinHeapTest {

    @BeforeEach
    public void setUp() {

        MinHeap minHeap = new MinHeap();
    }
    
    
    @Test
    public void testInsert() {

        minHeap.insert('A');
        minHeap.insert('B');

        assertEquals(2, minHeap.size())
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
    public void testSize() {

        minHeap.insert(1);
        assertEquals(1, minHeap.size());

        minHeap.insert(2);
        minHeap.inster(4);
        minHeap.insert(60);
        assertEquals(4, minHeap.size());

        minHeap.delete(2);
        assertEquals(2, minHeap.size());

    }

    @Test 
    public void testIsEmpty() {

        assertTrue(minHeap.isEmpty());
    }

    @Test 
    public void testToString() {

        assertEquals("[]", minHeap.toString());

        minHeap.insert('C');
        minHeap.insert('A');
        minHeap.insert('B');

        String expectedMinHeap = "[A, C, B]"; // Heap property should hold
        assertEquals(expectedMinHeap, minHeap.toString());

    

    }
    
}
