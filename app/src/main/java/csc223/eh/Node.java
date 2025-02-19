package csc223.eh;

public class Node {
    char data;
    Node next;
    Node previous; // Add this field for doubly linked list

    public Node(char data) {
        this.data = data;
        this.next = null;
        this.previous = null; // Initialize the previous field
    }

}