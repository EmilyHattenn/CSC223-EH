package csc223.eh;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    
    public class BSTNode {
        int data;
        BSTNode left;
        BSTNode right;
    
        public BSTNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    // Root of the BST
    private BSTNode root;

    // Trying instead of construtor
    public BinarySearchTree() {
        this.root = null;
    }
    
    // Manually updates the root node
    public void setRoot(BSTNode root) {
        this.root = root;
    }
    


    // Insert Method
 
    public void insert(int value) {
        /* Inserts a new element to the BST. 
        If the element is already in the BST, 
        it should not be added again. */ 

        root = insertHelper(value, this.root);
    }

    private BSTNode insertHelper(int value, BSTNode curr) {
        /* Helper method to insert a new element to the BST. */

        // Base Case
        if (curr == null) {
            return new BSTNode(value);
        }

        // Recursive Case
        if (value <= curr.data) {
            curr.left = insertHelper(value, curr.left);
        } else if (value > curr.data){
            curr.right = insertHelper(value, curr.right);
        } 
        return curr;
    }


    // Delete Method

    public void delete(int value) {
        /* Deletes an element from the BST. 
           If the element is not found, 
           it should not be deleted. */

        
        System.out.println("\nDeleting: " + value); // Debugging

        root = deleteHelper(root, value);
    }
    
    private BSTNode deleteHelper(BSTNode curr, int value) {
        // Base Case: If tree is empty or node not found
        if (curr == null) {
            System.out.println("Node not found!"); // Debugging
            return null;
        }
        
        System.out.println("Visiting Node: " + curr.data); // Debugging

        // Recursive Case: Traverse left or right
        if (value < curr.data) {
            System.out.println("Going left from " + curr.data); // Debugging
            curr.left = deleteHelper(curr.left, value);
        } else if (value > curr.data) {
            System.out.println("Going right from " + curr.data); // Debugging
            curr.right = deleteHelper(curr.right, value);
        } else {

            System.out.println("Found node to delete: " + curr.data); // Debgging

            // Case 1: Node has one child or no children
            if (curr.left == null) {
                System.out.println("Node has no left child. Replacing with right child.");
                return curr.right; // Replace node with right child
            }
            if (curr.right == null) {
                System.out.println("Node has no right child. Replacing with left child.");
                return curr.left; // Replace node with left child
            }
    
            // Case 2: Node has two children
            System.out.println("Node has two children. Finding inorder successor.");
            // Find inorder successor (smallest value in right subtree)
            curr.data = minValue(curr.right);
            System.out.println("Inorder Successor: " + curr.data);
            
            // Delete the inorder successor
            curr.right = deleteHelper(curr.right, curr.data);
        }
        return curr; // Return the updated node
    }
    
    /** Finds the minimum value in the subtree */
    private int minValue(BSTNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }
    
    

    // Search Method
 
    public boolean search(int value) {
        /* Returns true if the BST contains the specified element, 
        and false otherwise.*/

       return searchHelper(value, new LinkedList<>());
    }

    private boolean searchHelper(int value, Queue<BSTNode> queue) {
        /* Helper method to search for an element in the BST. */

        if (root == null) {
            return false;
        }
        // Initialize queue only on first call
        if (queue.isEmpty()) {
            queue.add(root);
        }
        
         // Base case: No nodes left to process
        if (queue.isEmpty()){
            return false;
        }

        // Recursive Case
        BSTNode curr = queue.poll();
        if (curr.data == value) {
            return true;
        }

        if (curr.left!= null) {
            queue.add(curr.left);
        }
        if (curr.right != null) {
            queue.add(curr.right);
        }

        // Recursive call with updated queue
        return searchHelper(value, queue);
    } 
    



    // Update Method

    public void update(int oldValue, int newValue) {
        /* Updates an element in the BST. If the element 
        is not in the BST, the method should do nothing.*/
        if (!search(oldValue)) return; // Ensure oldValue exists

        delete(oldValue);
        insert(newValue);
    }



    // Traversal Method (inOrder)

    public String inOrder() {
        /* Returns a string representation of all elements in the 
        BST in-order traversal. */

        StringBuilder sb = new StringBuilder();
        inOrderHelper(root, sb);
        return sb.toString().trim();

    }

    private void inOrderHelper(BSTNode node, StringBuilder sb) {
        /* Helper method to perform in-order traversal of the BST. */

        // Base Case
        if (node != null) {
            inOrderHelper(node.left, sb);
            sb.append(node.data).append(" ");
            inOrderHelper(node.right, sb);
        }
    }


    // Sorted Array to BST Method
    public BSTNode sortedArrayToBST(int[] values) {
        /*Creates a height-balanced BST from a sorted array of integers. 
        The method should return the root of the BST. */
        
        root = sortedArrayToBSTHelper(values, 0, values.length -1);
        return root;

    }

    private BSTNode sortedArrayToBSTHelper(int[] values, int left, int right) {
        /* Helper method to create a height-balanced BST from a sorted array. */

        // Base Case 
        if (left > right) {
            return null;
        }

        // Recursive Case

        int mid = left + (right - left) / 2;
        BSTNode node = new BSTNode(values[mid]);

        System.out.println("Creating Node: " + node.data + " (Mid: " + mid + ")"); // Debugging


        node.left = sortedArrayToBSTHelper(values, left, mid - 1);
        node.right = sortedArrayToBSTHelper(values, mid + 1, right);

        return node;
    }



    public int lowestCommonAncestor(int p, int q) {
        /* Returns the lowest common ancestor of two elements in the BST. 
        If either element is not in the BST, the method should return -1. */
        
        return lowestCommonAncestorHelper(root, p, q);
        
    }

    private int lowestCommonAncestorHelper(BSTNode node, int p, int q) {
        /* Helper method to find the lowest common ancestor of two elements. */

        // Base Case
        if (node == null) {
            return -1;
        }

        // Recursive Case
        if (p < node.data && q < node.data) {
            return lowestCommonAncestorHelper(node.left, p, q);
        }
        if (p >node.data &&  q > node.data) {
            return lowestCommonAncestorHelper(node.right, p, q);
        }
        return node.data;
        
    }


    
}
