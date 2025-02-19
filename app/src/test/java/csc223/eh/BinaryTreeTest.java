package csc223.eh;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinaryTreeTest {
    private BinaryTree tree;

    @BeforeEach
    public void setUp() {
        tree = new BinaryTree();
    }

    @Test
    public void isEmptyTest() {
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());
        assertEquals(0, tree.height());
        assertEquals("", tree.levelOrder());
        assertEquals("", tree.preOrder());
        assertEquals("", tree.inOrder());
        assertEquals("", tree.postOrder());
    }

    @Test 
    public void insertTest() {
        tree.insert('E');
        tree.insert('M');
        tree.insert('I');   
        tree.insert('L');
        tree.insert('Y');

        // Expected structure:
        //      E
        //     / \
        //    M   I
        //   / \
        //  L   Y

        assertEquals("EMILY", tree.levelOrder());  // Level-order (root → left → right)
        assertEquals("EMLYI", tree.preOrder());    // Preorder (root → left → right)
        assertEquals("LMYEI", tree.inOrder());     // Inorder (left → root → right)
        assertEquals("LYMIE", tree.postOrder());   // Postorder (left → right → root)

    }

    @Test
    public void levelOrderTest() {
        tree.insert('E');
        tree.insert('M');
        tree.insert('I');
        tree.insert('L');
        tree.insert('Y');
        assertEquals("EMILY", tree.levelOrder());
    }

    @Test
    public void preOrderTest() {
        tree.insert('E');
        tree.insert('M');
        tree.insert('I');
        tree.insert('L');
        tree.insert('Y');
        assertEquals("EMLYI", tree.preOrder());
    }

    @Test
    public void inOrderTest() {
        tree.insert('E');
        tree.insert('M');
        tree.insert('I');
        tree.insert('L');
        tree.insert('Y');
        assertEquals("LMYEI", tree.inOrder());
    }

    @Test
    public void postOrderTest() {
        tree.insert('E');
        tree.insert('M');
        tree.insert('I');
        tree.insert('L');
        tree.insert('Y');
        assertEquals("LYMIE", tree.postOrder());
    }

    @Test
    public void searchTest() {
        tree.insert('E');
        tree.insert('M');
        tree.insert('L');
        tree.insert('I');

        assertTrue(tree.search('E'));
        assertTrue(tree.search('M'));
        assertTrue(tree.search('I'));
        assertTrue(tree.search('L'));
        assertFalse(tree.search('Z'));
        assertFalse(tree.search('Y'));
    }
    
    @Test
    public void sizeTest() {
        assertEquals(0, tree.size());
        tree.insert('E');
        tree.insert('S');
        tree.insert('H');
        assertEquals(3, tree.size());
    }

    @Test
    public void heightTest() {
        assertEquals(0, tree.height());
        tree.insert('E');
        assertEquals(1, tree.height());
        tree.insert('S');
        tree.insert('H');
        assertEquals(2, tree.height());
    }
}
