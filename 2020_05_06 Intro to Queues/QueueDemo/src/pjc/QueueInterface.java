package pjc;

public interface QueueInterface
{
    // returns true if the queue is empty (no items in queue) 
    // false if queue is (has at least one or more items in queue)
    public boolean isEmpty();
    
    // clear the queue
    public void clear();
	
    // return the number of items currently in the queue
    public int size();
 
    // returns the value of the item currently at front of queue
    public int front();
	
    // returns the value of the item currently at the end of the queue
    public int back();
    
    // returns the value of the item currently at front of queue
    // (this is synonymous to the front method)
    public int peek_front();
	
    // returns the value of the item currently at the end of the queue
    // (this is synonymous to the back method)
    public int peek_back();
	
    // places parameter newItem onto the end of the queue
    // (this is synonymous to the enqueue method)
    public void push_back(int newItem);
	
    // places parameter newItem onto the end of the queue
    // (this is synonymous to the push_back method)
    public void enqueue(int newItem);
	
    // returns and removes the current item at the front of the queue
    // the item that is in the queue behind the item becomes the new front item
    public int pop_front();
	
    // returns and removes the current item at the front of the queue
    // (this is synonymous to the pop_front method)
    public int dequeue();
    
    // two toString methods
    @Override
    public String toString();    
    public String toString(boolean verbose);
}