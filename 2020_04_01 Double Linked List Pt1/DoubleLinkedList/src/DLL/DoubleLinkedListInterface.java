package DLL;

public interface DoubleLinkedListInterface<T> {
    // check to see if the linked list is empty
    public boolean isEmpty();
    
    // get the size of the linked list
    public int getSize();
    
    // insertFront, insertBack, insertAt functions
    public void insertFront(T item);
    public void insertBack(T item);
    public void insertAt(T item, int position);
    
    // removeFront, removeBack, removeAt functions
    public T removeFront();
    public T removeBack();
    public T removeAt(int position);
    
    // toString function to output our double linked list
    public String toString();
}
