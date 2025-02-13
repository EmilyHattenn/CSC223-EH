package csc223.eh;



public class SinglyLinkedList implements LinkedList {
    protected Node head;
    protected int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    
    public void insert(char item) {

        // Create a New Node
        Node newNode = new Node(item);
        // Update the head pointer of the current node
        if (head == null) {
            head = newNode;
        } else { 
            Node current = head;
            while (current.next != null) {
                // Iterate through the Linked List
                current = current.next;
            }
            current.next = newNode;
        }
        
        // Increase the Size by 1
        size++;
    }

  
    public void remove(char item) {

        // Check if list is empty
        if (head == null) return;
        

        // Check if Node Exists
        if (head.data == item) {
            head = head.next;
            size--;
            return;
        }
         
        
        Node current = head;
        while (current.next != null && current.next.data != item) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            size--;
        }

        
    }

    
    public char getFirst() {
        return (head != null) ? head.data : '☠';
    }

  
    public char getLast() {
        if (head == null) return '☠';
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }


    public char get(int index) {
        if (index < 0 || index >= size) return '☠';
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

  
    public int size() {
        return size;
    }

  
    public boolean isEmpty() {
        return head == null;
    }


    public void clear() {
        head = null;
        size = 0;
    }

 
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


    public int lastIndexOf(char item) {
        Node current = head;
        int index = 0, lastIndex = -1;
        while (current != null) {
            if (current.data == item) lastIndex = index;
            current = current.next;
            index++;
        }
        return lastIndex;
    }


    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            current = current.next;
        }
        return sb.toString();
    }


} 