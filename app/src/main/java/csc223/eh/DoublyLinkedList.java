package csc223.eh;

public class DoublyLinkedList extends SinglyLinkedList {

    @Override
    public void insert(char item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.previous = current;
        }
        size++;
    }

    @Override
    public void remove(char item) {
        if (head == null) return;

        if (head.data == item) {
            head = head.next;
            if (head != null) head.previous = null;
            size--;
            return;
        }

        Node current = head;
        while (current != null && current.data != item) {
            current = current.next;
        }

        if (current != null) {
            if (current.next != null) current.next.previous = current.previous;
            if (current.previous != null) current.previous.next = current.next;
            size--;
        }
    }
}
