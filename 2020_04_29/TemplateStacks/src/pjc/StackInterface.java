package pjc;

public interface StackInterface<T> {
    
    // push value onto stack
    public void push(T value);
    
    // peek at value at top of stack
    public T peek();
    
    // pop value off the stack
    public T pop();
    
    // check if stack is empty
    public boolean isEmpty();
    
    // clear method for clearing the stack
    public void clear();
    
    // toString overrided from Object class
    public String toString();
    
    // display string, displays stack such as: ((TOP)) [data] [data] ... [data] ((BOTTOM))
    public void display();
}
