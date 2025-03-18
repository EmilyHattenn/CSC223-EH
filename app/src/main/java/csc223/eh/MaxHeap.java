package csc223.eh;

public class MaxHeap {
    
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

    public MaxHeap(Node root) {
        /* Constructor for the MinHeap class. */
        this.root = root;
        this.size = 0;
    }

    public void insert(char value) {
        /*Inserts a new element to the heap*/

        // If the heap is empty

        insertHelper(value, this.root);
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

    }

    private Node deleteHelper(Node curr) {
        /* Helper method to delete the root element from the heap. */

        // Base Case


        //Recursive Case
    } 
    
    public Node peek() {
        /*Returns the root element of the heap.*/

    } 

    private Node peekHelper(Node curr) {
        /* Helper method to return the root element of the heap. */


        // Base Case


        //Recursive Case

    }

    public int size() {
        /*Returns the number of elements in the heap.*/

        // If the heap is empty
        if (this.root == null) {
            return -1;
        } else {
            // Return the size of the heap
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



    }


}
