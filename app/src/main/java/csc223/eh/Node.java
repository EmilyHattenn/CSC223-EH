package csc223.eh;

public class Node {
    public char data;       // The character data stored in this node
    public Node next;       // Reference to the next node
  
    // Constructor
    public Node(char data) {
        this.data = data;
        this.next = null;
    }
}