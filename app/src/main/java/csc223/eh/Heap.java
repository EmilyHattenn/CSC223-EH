package csc223.eh;

public interface  Heap {

    void insert(char value); //Inserts a new element to the heap.
    void delete(); //Deletes the root element from the heap.
    int peek(); //Returns the root element of the heap.
    int size(); //Returns the number of elements in the heap.
    boolean isEmpty(); //Returns true if the heap is empty, and false otherwise.
    void clear(); //Clears the heap.
    String toString(); //Returns a string representation of all elements in the heap.
        
}
