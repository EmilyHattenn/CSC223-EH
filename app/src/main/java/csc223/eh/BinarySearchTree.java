package csc223.eh;

public class BinarySearchTree {

    public static class BSTNode {
        public BSTNode left;
        public BSTNode right;
        public int data;
    
        public BSTNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    BSTNode root; // Root of the BST

    // Constructor
    public BinarySearchTree() {

    }
    

    // Insert Method: Inserts a new element to the BST. If the element is already in the BST, it should not be added again.
    public void insert(int value) {
        root = insertHelper(value, root);
    }

    private BSTNode insertHelper(int value, BSTNode curr) {
        if (curr == null) {
            return new BSTNode(value);
        }
    
        if (value < curr.data) {
            curr.left = insertHelper(value, curr.left);
        } else if (value > curr.data) {
            curr.right = insertHelper(value, curr.right);
        }
        // Skip if value == curr.data
        return curr;
    }
    


    // Delete Method: Deletes an element from the BST. If the element is not found, it should not be deleted.
    public void delete(int value) {
        root = deleteHelper(root, value);
    }
    
    private BSTNode deleteHelper(BSTNode curr, int value) {
        if (curr == null) {
            return null;
        }
    
        if (value < curr.data) {
            curr.left = deleteHelper(curr.left, value);
        } else if (value > curr.data) {
            curr.right = deleteHelper(curr.right, value);
        } else {
            // Node to be deleted found
    
            // Case 1: One or no child
            if (curr.left == null) return curr.right;
            if (curr.right == null) return curr.left;
    
            // Case 2: Two children – find min in right subtree
            BSTNode successor = curr.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            int min = successor.data;
    
            curr.data = min;
    
            curr.right = deleteHelper(curr.right, min);
        }
    
        return curr;
    }
    

    // Search Method
    public boolean search(int value) {
        /* Returns true if the BST contains the specified element, 
        and false otherwise.*/

       return searchHelper(value, root);
    }

    private boolean searchHelper(int value, BSTNode curr) {
        /* Helper method to search for an element in the BST. */

        // Base Case
        if (curr.data == value) {
            return true;
        }
        
        // Recursive Case
        if (value < curr.data && curr.left != null) {
            if (searchHelper(value, curr.left)) {
                return true;
            }
        } else if (value > curr.data && curr.right != null) {
            if (searchHelper(value, curr.right)) {
                return true;
            }
        }

        return false;
    } 


    // Update Method
    public void update(int oldValue, int newValue) {
        /* Updates an element in the BST. If the element 
        is not in the BST, the method should do nothing.*/
        updateHelper(oldValue, newValue, root);
    }

    private boolean updateHelper(int oldValue, int newValue, BSTNode curr) {
        
        // Base Case
        if (root.data == oldValue) {
            root.data = newValue;
            return true;
        }

        // Recursive Case
        if (curr.data == oldValue) {
            return true;
        }
            if (oldValue < curr.data && curr.left != null) {
                if (updateHelper(oldValue, newValue, curr.left)){
                    curr.left.data = newValue;
                }
            } else if (oldValue > curr.data && curr.right != null) {
                if (updateHelper(oldValue, newValue, curr.right)) {
                    curr.right.data = newValue;
                }
            }
            return false;
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
    public int sortedArrayToBST(int[] values) {
        /*Creates a height-balanced BST from a sorted array of integers. 
        The method should return the root of the BST. */
        
        root = null;
        sortedArrayToBSTHelper(values, 0, values.length -1);
        return root.data;

    }

    private void sortedArrayToBSTHelper(int[] values, int left, int right) {
        /* Helper method to create a height-balanced BST from a sorted array. */

        // Base Case 
        if (left > right) {
            return;
        }

        // Recursive Case

        int mid = (right + left) / 2;
       
        insert(values[mid]);
        sortedArrayToBSTHelper(values, left, mid - 1);
        sortedArrayToBSTHelper(values, mid + 1, right);
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
