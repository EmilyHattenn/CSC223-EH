package csc223.eh;


public class BinarySearchTree  {
    
    // Node class to represent each node in the BST
    public class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    // Root of the BST
    private Node root;

    // Constructor
    public BinarySearchTree() {
        this.root = null;
    }



    // Insert Method
    public void insert(int value) {
        /* Inserts a new element to the BST. 
        If the element is already in the BST, 
        it should not be added again. */ 

        root = insertHelper(value, this.root);
    }

    private Node insertHelper(int value, Node curr) {
        /* Helper method to insert a new element to the BST. */

        // Base Case
        if (curr == null) {
            return new Node(value);
        }

        // Recursive Case
        if (value <= curr.value) {
            curr.left = insertHelper(value, curr.left);
        } else {
            curr.right = insertHelper(value, curr.right);
        } 
        return curr;
    }


    // Delete Method
    public void delete(int value) {
        /* Deletes an element from the BST. 
        If the element is not found, 
        it should not be deleted. */

        // If the tree is empty
        root = deleteHelper(value, this.root);
    }

    private Node deleteHelper(int value, Node curr) {
        /* Helper method to delete an element from the BST. */

        // Base Case
        if (curr == null) {
            return null;
        }

        //Recursive Case
        if (value < curr.value) {
            curr.left = deleteHelper(value, curr.left);
        } else if (value > curr.value) {
            curr.right = deleteHelper(value, curr.right);
        } else { 

            // Node with 1 or no childeren
            if (curr.left == null) {
                return curr.right;
            } else if (curr.right == null) {
                return curr.left;
            }

            // Node with 2 children
            Node minNode = findMin(curr.right);
            curr.value = minNode.value;
            curr.right = deleteHelper(minNode.value, curr.right);
        
    }
    return curr;
}
    
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


    // Search Method
    public boolean search(int value) {
        /* Returns true if the BST contains the specified element, 
        and false otherwise.*/

        //If the tree isEmpty
       return searchHelper(value, root);
    }

    private boolean searchHelper(int value, Node curr) {
        /* Helper method to search for an element in the BST. */

        // Base Case 
        if (curr == null) {
            return false;
        }

        // Recursive Case
        if (curr.value == value) {
            return true;
        } else if (value < curr.value) {
            return searchHelper(value, curr.left);
        } else {
            return searchHelper(value, curr.right);
        } 
    }




    // Update Method
    public Node update(int oldValue, int newValue) {
        /* Updates an element in the BST. If the element 
        is not in the BST, the method should do nothing.*/

        // If the Tree is Empty
        updateHelper(oldValue, newValue, root);
        return root;
    }

    private boolean updateHelper(int oldValue, int newValue, Node node) {
        /* Helper method to update an element in the BST. */

        // Base Case 
        if (node == null) {
            return false;
        }

        // Recursive Case
        if (node.value == oldValue) {
            if ((node.left == null || node.left.value < newValue) && (node.right == null || node.right.value > newValue)){
                node.value = newValue;
                return true;
            } 
            return false;
        }

        if (oldValue < node.value) {
            return updateHelper(oldValue, newValue, node.left);
        } else {
            return updateHelper(oldValue, newValue, node.right);
        }
    }



    // Traversal Method (inOrder)
    public String inOrder() {
        /* Returns a string representation of all elements in the 
        BST in-order traversal. */

        return inOrderHelper(root).trim();

    }

    private String inOrderHelper(Node node) {
        /* Helper method to perform in-order traversal of the BST. */

        // Base Case
        if (node == null) {
            return "";
        }
        // Recursive Case
        return inOrderHelper(node.left) + node.value + " " + inOrderHelper(node.right);
    }


    // Sorted Array to BST Method
    public Node sortedArrayToBST(int[] values) {
        /*Creates a height-balanced BST from a sorted array of integers. 
        The method should return the root of the BST. */

        if (values == null || values.length == 0) return null;
        root = sortedArrayToBSTHelper(values, 0, values.length - 1);
        return root;


    }

    private Node sortedArrayToBSTHelper(int[] values, int start, int end) {
        /* Helper method to create a height-balanced BST from a sorted array. */

        // Base Case 
        if (start > end) {
            return null;
        }

        // Recursive Case
        int mid = (start + end) / 2;
        Node node = new Node(values[mid]);
        node.left = sortedArrayToBSTHelper(values, start, mid - 1);
        node.right = sortedArrayToBSTHelper(values, mid + 1, end);
        return node;
    }



    public Node lowestCommonAncestor(int p, int q) {
        /* Returns the lowest common ancestor of two elements in the BST. 
        If either element is not in the BST, the method should return -1. */
        
        // If nodes are not in the tree
        if (!search(p) || !search(q)) {
            return null;
        }
        return lowestCommonAncestorHelper(root, p, q);
        
    }

    private Node lowestCommonAncestorHelper(Node node, int p, int q) {
        /* Helper method to find the lowest common ancestor of two elements. */

        // Base Case
        if (node == null) {
            return null;
        }

        // Recursive Case
        if (node.value > p && node.value > q) {
            return lowestCommonAncestorHelper(node.left, p, q);
        }
        if (node.value < p && node.value < q) {
            return lowestCommonAncestorHelper(node.right, p, q);
        }
        return node;
        
    }


}
