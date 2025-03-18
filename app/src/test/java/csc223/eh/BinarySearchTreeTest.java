package csc223.eh;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {

    private BinarySearchTree bst;

    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree();
    }

    @Test
    void testInsertAndSearch() {

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
    void testDelete() {

        // Test deleting a leaf node
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);

        bst.delete(3); // Deleting leaf node
        assertFalse(bst.search(3));
        assertTrue(bst.search(10));
    }



    @Test
    void testUpdate() {
    
        
        // Insert elements
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Update existing node
        bst.update(40, 35);
        assertFalse(bst.search(40));
        assertTrue(bst.search(35));

        // Attempt to update non-existing node
        bst.update(100, 90);
        assertFalse(bst.search(90));

    }

    @Test
    void testInOrder() {
      
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
    void testSortedArrayToBST() {
    

        // Test sorted array to BST conversion
        int[] sortedArray = {20, 30, 40, 50, 60, 70, 80};
        BinarySearchTree.Node root = bst.sortedArrayToBST(sortedArray);

        // Root should be middle element
        assertEquals(50, root.value);

        // Check left and right children
        assertEquals(70, root.left.value);
        assertEquals(60, root.right.value);
    }

    @Test
    void testLowestCommonAncestor() {
    

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        assertEquals(5, bst.lowestCommonAncestor(2, 8).value);
        assertEquals(3, bst.lowestCommonAncestor(2, 4).value);
    }
}
