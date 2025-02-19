package csc223.eh;

public class SinglyLinkedList implements LinkedList {

    // Protected access modifier is used to restrict the access of a class, constructor, data member and method in another class.
    // It can be accessed using inheritance.
    protected Node head;  // Head of the Linked List
    protected int size;   // Size of the Linked List

    // Constructor
    public SinglyLinkedList() {

        this.head = null;   // Initialize the head to null
        this.size = 0;    // Initialize the size to 0
    }

    @Override
    public void insert(char item) {

        // Create a New Node
        Node newNode = new Node(item);

        // Update the head pointer of the current node
        if (head == null) {
            head = newNode;
        } else { 
            // Travsere to the Last Node
            Node current = head;
            while (current.next != null) {
                // Iterate through the Linked List
                current = current.next;
            }
            // Update the next pointer of the last node
            current.next = newNode;
        }
        
        // Increase the Size by 1
        size++;
    }

  
    @Override
    public void remove(char item) {

        // Check if list is empty
        if (head == null) return;
        

        // Check if Node Exists
        if (head.data == item) {
            // Update the head pointer
            head = head.next;
            size--;
            return;
        }
         
        // Traverse the Linked List
        Node current = head;
        // Iterate through the Linked List
        while (current.next != null && current.next.data != item) {
            // Iterate through the Linked List
            current = current.next;
        }

        // Remove the Node  
        if (current.next != null) {
            // Update the next pointer of the current node
            current.next = current.next.next;
            size--;
        }

        
    }

    @Override
    public char getFirst() {
        // Return the first element of the Linked List
        return (head != null) ? head.data : 'x';
    }

    @Override
    public char getLast() {
        // Return the last element of the Linked List
        if (head == null) return 'x';
        // Traverse the Linked List
        Node current = head;
        // Iterate through the Linked List
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public char get(int index) {
        // Check if the index is out of bounds
        if (index < 0 || index >= size) return 'x';
        Node current = head;
    
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean contains(char item) {
        Node current = head;
        while (current != null) {
            if (current.data == item) {
                // 
                return true;
            } else {
                // 
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public int indexOf(char item) {
        Node current = head;
        int index = 0;
        while (current!= null) {
            if (current.data == item) {
                return index;
            } else {
                current = current.next;
                index++;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(char item) {
        Node current = head;
        int index = 0;
        int lastIndex = -1;
        //
        while (current != null) {
            
            if (current.data == item) lastIndex = index;
            current = current.next;
            index++;
        }
        return lastIndex;
    }

    @Override
    public void reverse() {
        //
        Node prev = null;
        Node current = head;
        //
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    @Override
    public String toString() {
        //
        StringBuilder sb = new StringBuilder();
        Node current = head;
        // Go through the entire LinkedList
        while (current != null) {
            sb.append(current.data);
            current = current.next;
        }
        return sb.toString();
    }


} 