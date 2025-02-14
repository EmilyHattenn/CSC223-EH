package csc223.eh;

public class DoublyLinkedList extends SinglyLinkedList {

    @Override
    public void insert(char item) {
        Node newNode = new Node(item);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.previous = current;
        }
        this.size++;
    }

    @Override
    public void remove(char item) {
        if (this.head == null) return;

        if (this.head.data == item) {
            this.head = this.head.next;
            if (this.head != null) this.head.previous = null;
            this.size--;
            return;
        }

        Node current = this.head;
        while (current != null && current.data != item) {
            current = current.next;
        }

        if (current != null) {
            if (current.next != null) current.next.previous = current.previous;
            if (current.previous != null) current.previous.next = current.next;
            this.size--;
        }
    }
}
