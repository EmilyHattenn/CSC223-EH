package csc223.eh;

public interface LinkedList{

    void insert(char item); // Insert an item at the end of the list for unsorted lists
    void remove(char item); // Removes an item from the list
    char getFirst(); // Get the first item, return '☠' if the list is empty
    char getLast(); // Get the last item, return '☠' if the list is empty
    char get(int index); // Get an item at a specific index, return '☠' if index is out of bounds
    int size(); // Get the size of the list
    boolean isEmpty(); // Check if the list is empty
    void clear(); // Clear the list
    boolean contains(char item); // Check if the list contains an item
    int indexOf(char item); // Get the index of an item, if it exists else return -1
    int lastIndexOf(char item); // Get the last index of an item, if it exists else return -1
    void reverse(); // Reverse the list
    String toString(); // Creates and returns a String representation of the list
    // e.g. `A -> B -> C -> D` should return "ABCD"
}
