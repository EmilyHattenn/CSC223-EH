package csc223.eh;

public class MinHeap {

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

    private Node root; // The root of the heap
    private int size; // The number of elements in the heap

    public MinHeap(Node root) {
        /* Constructor for the MinHeap class. */
        this.root = root;
        this.size = 0;
    }

    public void insert(char value) {
        /*Inserts a new element to the heap*/

        // If the heap is empty
        root = insertHelper(value, this.root);
    }

    private Node insertHelper(char value, Node curr) {
        /* Helper method to insert a new element to the heap. */

        // Base Case
        if (curr == null) {
            curr = new Node(value);
            this.size++;
        }

        // Recursive Case
        if (value < curr.value) {
            curr.left = insertHelper(value, curr.left);
        } else if (value > curr.value) {
            curr.right = insertHelper(value, curr.right);
        } 
        return curr;
    }

    public void delete() {
        /*Deletes the root element from the heap.*/

        // If the heap is empty
    }

    private Node deleteHelper(Node curr) {
        /* Helper method to delete the root element from the heap. */

        // Base Case


        //Recursive Case

    }
    
    public Node peek() {
        /*Returns the root element of the heap.*/

        peekHelper(this.root);
    } 

    private Node peekHelper(Node curr) {
        /* Helper method to return the root element of the heap. */

        // Base Case
        if (curr == null) {
            return null;
        }

        // Recursive Case
        if (curr.left != null) {
            return peekHelper(curr.left);
        } else {
            return curr;
        }
    }

    public int size() {
        /*Returns the number of elements in the heap.*/

        // If the heap is empty
        if (this.root == null) {
            return -1;
        } else {
            return this.size;
        }
    }


    public boolean isEmpty() {
        /*Returns true if the heap is empty, and false otherwise. */

        return this.size == 0;
    }
    public void clear() {
        /*Clears the heap.*/

        this.root = null;
        this.size = 0;
    }
    public String toString() {
        /* Returns a string representation of all elements in the heap. */

        return toStringHelper(this.root);
        
    }

    private Node toStringHelper(Node curr) {
        /* Helper method to return a string representation of all elements in the heap. */

        // Base Case
        if (curr == null) {
            return "";
        }

        // Recursive Case
        StringBuilder sb = new StringBuilder();
        sb.append(curr.value);
        if (curr.left != null) {
            sb.append(toStringHelper(curr.left));
        }
        if (curr.right != null) {
            sb.append(toStringHelper(curr.right));
        }
        return sb.toString();
    }
    
}
