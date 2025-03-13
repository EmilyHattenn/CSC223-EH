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
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        assertTrue(bst.search(5));
        assertTrue(bst.search(3));
        assertTrue(bst.search(7));
        assertTrue(bst.search(2));
        assertTrue(bst.search(4));
        assertTrue(bst.search(6));
        assertTrue(bst.search(8));

        assertFalse(bst.search(10)); // Element not inserted
    }

    @Test
    void testDelete() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        bst.delete(3);
        assertFalse(bst.search(3)); // Ensure 3 is deleted
        assertTrue(bst.search(2)); // Ensure 2 is still present
        assertTrue(bst.search(4)); // Ensure 4 is still present
    }

    @Test
    void testDeleteLeafNode() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);

        bst.delete(3); // Deleting leaf node
        assertFalse(bst.search(3));
        assertTrue(bst.search(10));
    }

    @Test
    void testDeleteNodeWithOneChild() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(12);

        bst.delete(15); // Node with one child (12)
        assertFalse(bst.search(15));
        assertTrue(bst.search(12)); // Ensure child is still present
    }

    @Test
    void testDeleteNodeWithTwoChildren() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(12);
        bst.insert(18);

        bst.delete(15); // Node with two children (12 and 18)
        assertFalse(bst.search(15));
        assertTrue(bst.search(12));
        assertTrue(bst.search(18));
    }

    @Test
    void testInOrderTraversal() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        assertEquals("2 3 4 5 6 7 8", bst.inOrder());
    }

    @Test
    void testUpdate() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        bst.update(5, 6);
        assertFalse(bst.search(5));
        assertTrue(bst.search(6));
    }

    @Test
    void testSortedArrayToBST() {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7};
        bst.sortedArrayToBST(sortedArray);

        assertTrue(bst.search(4)); // Root node
        assertTrue(bst.search(2));
        assertTrue(bst.search(6));
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
