package csc223.eh;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;


public class BinarySearchTreeTest {

    @Test
    public void testInsertAndSearch() {
        BinarySearchTree bst = new BinarySearchTree();

        // Test insert and search functionality
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        assertTrue(bst.search(50));
        assertTrue(bst.search(30));
        assertTrue(bst.search(70));
        assertTrue(bst.search(20));
        assertTrue(bst.search(40));
        assertTrue(bst.search(60));
        assertTrue(bst.search(80));

        assertFalse(bst.search(10)); // Element not inserted
        assertFalse(bst.search(90)); // Element not inserted
    }


    @Test
    public void testDelete() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        assertEquals("20 30 40 50 60 70 80", bst.inOrder());

        bst.delete(50); // root with two children
        assertEquals("20 30 40 60 70 80", bst.inOrder());

        bst.delete(80); // leaf
        assertEquals("20 30 40 60 70", bst.inOrder());
    }

    




    @Test
    public void testUpdate() {
        BinarySearchTree bst = new BinarySearchTree();
    
        
        // Insert elements
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        assertEquals("20 30 40 50 60 70 80", bst.inOrder());

        bst.update(40, 35);
        assertEquals("20 30 35 50 60 70 80", bst.inOrder());
        
        bst.update(50,30);
        assertEquals("20 30  30 35 60 70 80", bst.inOrder());
        
        bst.update(20,21);
        assertEquals("21 30 30 35 60 70 80", bst.inOrder());


        bst.update(970, 1467);
        assertEquals("21 30 30 35 60 70 80", bst.inOrder());
    


    }

    @Test
    public void testInOrder() {
        BinarySearchTree bst = new BinarySearchTree();
      
        // Insert elements
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // In-order should return sorted order
        assertEquals("20 30 40 50 60 70 80", bst.inOrder());
    }

    @Test
    public void testSortedArrayToBST() {
        BinarySearchTree bst = new BinarySearchTree();
        int[] nums = {-10, -3, 0, 5, 9};
        assertEquals(0, bst.sortedArrayToBST(nums));
        assertEquals("-10 -3 0 5 9", bst.inOrder());

    }


    @Test
    public void testLowestCommonAncestor() {

        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        assertEquals(5, bst.lowestCommonAncestor(2, 8));
        assertEquals(3, bst.lowestCommonAncestor(2, 4));
    }
}
