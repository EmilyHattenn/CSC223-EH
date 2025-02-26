package csc223.eh;

// ArrayQueue class implements the Queue inteface
public class ArrayQueue implements Queue {

    // Declare the array to store the queue elements
    protected int[] array;

    // Declare the front and back pointers
    protected int front;
    protected int back;

    protected int len;
    protected int count;

    public ArrayQueue(int size) {

        // Initialize the queue
        this.array = new int[size];
        
        // Initialize the front and back pointers
        this.front = 0;
        // Initialize back pointer to -1 since the queue is empty
        this.back = -1;

        // Initalize the size of the queue
        this.len = size;

        // Initialize the count of elements in the queue
        this.count = 0;
    }

    @Override
    public void enqueue(int item) {
        if (count == len) {
            throw new IllegalStateException("Queue is Full");
        }
        back++;
        array[back] = item;
        count++;
    }

    @Override
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

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Queue is Empty");
        }
        return array[front];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
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

