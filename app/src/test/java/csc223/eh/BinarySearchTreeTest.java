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
    public void testInsertAndSearch() {

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
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);

        System.out.println("\n=== BEFORE DELETE ===");
        System.out.println(bst.inOrder()); // Print tree before deletion

        System.out.println("\n=== DELETE NODE 3 (Leaf) ===");
        bst.delete(3);
        assertFalse(bst.search(3));

        System.out.println("\n=== DELETE NODE 10 (Root with Two Children) ===");
        bst.delete(10);
        assertFalse(bst.search(10));

        System.out.println("\n=== AFTER DELETE ===");
        System.out.println(bst.inOrder()); // Print tree after deletion
    }




    @Test
    public void testUpdate() {
    
        
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
    public void testInOrder() {
      
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
        int[] sortedArray = {20, 30, 40, 50, 60, 70, 80};
        BSTNode root = bst.sortedArrayToBST(sortedArray);
        bst.setRoot(root);
        


        // Root should be the middle element
        assertEquals(50, root.data);

        // Check left and right children
        assertEquals(30, root.left.data);
        assertEquals(70, root.right.data);

        // Check further left and right children
        assertEquals(20, root.left.left.data);
        assertEquals(40, root.left.right.data);
        assertEquals(60, root.right.left.data);
        assertEquals(80, root.right.right.data);
    }


    @Test
    public void testLowestCommonAncestor() {


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
