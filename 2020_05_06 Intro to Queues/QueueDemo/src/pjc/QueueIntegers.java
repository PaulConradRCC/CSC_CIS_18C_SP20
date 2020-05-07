package pjc;

public class QueueIntegers implements QueueInterface {
    private int numberOfElements=0;
    private Node head=null, tail=null;
    
    // returns true if the queue is empty (no items in queue) 
    // false if queue is (has at least one or more items in queue)
    public boolean isEmpty()
    {
        return ( numberOfElements == 0 );
    }
    
    // clear the queue
    public void clear()
    {
        head = null;
        tail = null;
        numberOfElements = 0;
    }
	
    // return the number of items currently in the queue
    public int size()
    {
        return numberOfElements;
    }
 
    // returns the value of the item currently at front of queue
    public int front()
    {
        return head.getValue();  // return the value in the head node
    }
	
    // returns the value of the item currently at the end of the queue
    public int back()
    {
        return tail.getValue();
    }
    
    // returns the value of the item currently at front of queue
    // (this is synonymous to the front method)
    public int peek_front()
    {
        return this.front();
    }
	
    // returns the value of the item currently at the end of the queue
    // (this is synonymous to the back method)
    public int peek_back()
    {
        return this.back();
    }
	
    // places parameter newItem onto the end of the queue
    // (this is synonymous to the enqueue method)
    public void push_back(int newItem)
    {
        // if head node is null, make head and tail node contain the first node
        if ( head == null)
        {
            head = new Node(newItem);
            tail=head; // when first item is enqueued, head and tail are the same
        }
        else
        {
            Node newNode = new Node(newItem);
            tail.setNext(newNode);
            tail=newNode;            
        }
        numberOfElements++;
    }
	
    // places parameter newItem onto the end of the queue
    // (this is synonymous to the push_back method)
    public void enqueue(int newItem)
    {
        this.push_back(newItem);
    }
	
    // returns and removes the current item at the front of the queue
    // the item that is in the queue behind the item becomes the new front item
    public int pop_front()
    {
        int headDataValue = 0;
        if ( numberOfElements > 0 )
        {
            headDataValue = head.getValue();
            Node oldHead=head;
            head=head.getNext();
            oldHead.setNext(null);						
            this.numberOfElements--;
        }
        else throw new UnsupportedOperationException("Empty Queue - dequeue failed");
        return headDataValue;  // returns the data value from the popped head, null if queue empty
    }
	
    // returns and removes the current item at the front of the queue
    // (this is synonymous to the pop_front method)
    public int dequeue()
    {
        return this.pop_front();
    }
    
    @Override
    public String toString()
    {
        Node current = head;
        String result = "";
              
        if ( current == null )
        {
            result = "[Empty Queue]";
        }
        else
        {
            while ( current != null )
            {
                result = result + "[" + current.getValue() + "] ";
                current = current.getNext();
            }
        }
        
        return result;
    }
    
    public String toString(boolean verbose)
    {
        String result = this.toString();
        
        if (verbose)
        {
            if ( !result.equals("[Empty Queue]") )
                result = "((FRONT)) " + result + "((BACK))";
        }
        
        return result;
    }
    ///////////////////////////////////////////////////////////////////////////
    
    // Node Inner Class
    private class Node {
        private int value;
        private Node _next;
    
        public Node(int data) {
            value = data;            
            _next = null;
        }
    
        protected Node(int data, Node nextNode) {
            value = data;            
            _next = nextNode;
        }
		
        public Node getNext() {
            return _next;
        }
		
        public void setValue(int newValue)
        {
            value=newValue;
        }

        public int getValue() {
            return value;
        }
    
        public void setNext(Node newNextNode) {
            _next = newNextNode;
        }		
    }    
}
