package csc223.eh;

public class SortedLinkedList extends DoublyLinkedList {

    @Override
    public void insert(char item) {
        Node newNode = new Node(item);

        if (head == null || head.data >= item) {
            newNode.next = head;
            if (head != null) head.previous = newNode;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.data < item) {
                current = current.next;
            }

            newNode.next = current.next;
            if (current.next != null) current.next.previous = newNode;
            current.next = newNode;
            newNode.previous = current;
        }
        size++;
    }
}
