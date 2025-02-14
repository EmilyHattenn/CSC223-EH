package csc223.eh;


// Simple Linear Queue Implementation (No Circular Logic)
public class ArrayQueue implements Queue {
    private int[] array;
    private int front;
    private int back;
    private int len;
    private int count;

    public ArrayQueue(int size) {
        array = new int[size];
        front = 0;
        back = -1;
        len = size;
        count = 0;
    }

    public void enqueue(int item) {
        if (count == len) {
            throw new IllegalStateException("Queue is Full");
        }

        back++;
        array[back] = item;
        count++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Queue is Empty");
        }
        int item = array[front];

        // Shift elements left to maintain queue order
        for (int i = 0; i < count - 1; i++) {
            array[i] = array[i + 1];
        }

        back--;
        count--;
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Queue is Empty");
        }
        return array[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    // Main method for testing
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Queue Size: " + queue.size());
        System.out.println("Front Element: " + queue.peek());

        System.out.println("Removed: " + queue.dequeue());
        System.out.println("Is the queue empty? " + queue.isEmpty());
    }
}

