package pjc;

public class Deque<T> implements DequeInterface<T> {
    
    // nodes for the head and tail
    private Node<T> head, tail;
    
    // keep track of the number of items in the deque
    private int numberOfItems;
    
    public Deque()
    {
        head=null;
        tail=null;
        numberOfItems=0;
    }
    
    // clear
    public void clear()
    {
        head = null;
        tail = null;
        numberOfItems = 0;
    }
    
    // returns true if the deque is empty (no items in deque) 
    // false if deque is (has at least one or more items in deque)
    public boolean isEmpty()
    {
        return numberOfItems == 0;
    }
	
    // return the number of items currently in the deque
    public int size()
    {
        return numberOfItems;
    }
 
    // returns the value of the item currently at front of deque
    public T front()
    {
        T value = null;
        if ( head != null )
            value = head.getValue();
        return value;
    }
	
    // returns the value of the item currently at the end of the deque
    public T back()
    {
        T value = null;
        if ( tail != null )
            value = tail.getValue();
        return value;
    }
	
    // places parameter newItem onto the front of the deque
    public void enqueue_front(T newItem)
    {
        // if head is null
        if ( head == null )
        {
            head = new Node(newItem);
            tail = head;
        }
        else
        {
            Node<T> newNode = new Node(newItem);
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
        numberOfItems++;
    }

    // places parameter newItem onto the front of the deque
    public void push_front(T newItem)
    {
        this.enqueue_front(newItem);
    }

    // places parameter newItem onto the end of the deque
    public void enqueue_back(T newItem)
    {
        // if tail is null
        if ( tail == null )
        {
            tail = new Node(newItem);
            head = tail;
        }
        else
        {
            Node<T> newNode = new Node(newItem);
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
        numberOfItems++;
    }

    // places parameter newItem onto the end of the deque
    public void push_back(T newItem)
    {
        this.enqueue_back(newItem);
    }
    
    // returns and removes the current item at the front of the deque
    // the item that is in the deque behind the item becomes the new front item
    public T dequeue_front()
    {
        T value = null;
        if ( numberOfItems > 0 )
        {
            value = head.getValue();
            Node<T> oldHead = head;
            head = head.getNext();
            oldHead.setNext(null);
            oldHead.setPrevious(null);
            oldHead = null;
            numberOfItems--;
        }
        return value;
    }

    // returns and removes the current item at the front of the deque
    // the item that is in the deque behind the item becomes the new front item
    public T pop_front()
    {
        return this.dequeue_front();
    }

    // returns and removes the current item at the front of the deque
    // the item that is in the deque behind the item becomes the new front item
    public T dequeue_back()
    {
        T value = null;
        if ( numberOfItems > 0 )
        {
            value = tail.getValue();
            Node<T> oldTail = tail;
            tail = tail.getPrevious();
            oldTail.setNext(null);
            oldTail.setPrevious(null);
            oldTail = null;
            numberOfItems--;
        }
        return value;
    }

    // returns and removes the current item at the front of the deque
    // the item that is in the deque behind the item becomes the new front item
    public T pop_back()
    {
        return this.dequeue_back();
    }

    // display all of the contents in the deque from front to back
    public void display()
    {
        System.out.print( this.toString() );
    }
    
    // two toString methods
    @Override
    public String toString()
    {
        Node<T> current = head;
        String result = "";
              
        if ( current == null )
        {
            result = "[Empty Deque]";
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
            if ( !result.equals("[Empty Deque]") )
                result = "((FRONT)) " + result + "((BACK))";
        }
        
        return result;
    }
    
    //////////////////////////////////////////////////////////////////////////
    //// Node Inner Class ////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////
    private class Node<T> {
        private T value;
        private Node<T> previous, next;

        public Node(T data) {
            value = data;
            previous = null;
            next = null;
        }
    
        public Node(T data, Node previousNode, Node nextNode) {
            value = data;
            previous = previousNode;
            next = nextNode;
        }
		
        public Node<T> getNext() {
            return next;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setValue(T newValue)
        {
            value=newValue;
        }

        public T getValue() {
            return value;
        }

        public void setNext(Node<T> newNextNode) {
            next = newNextNode;
        }
		
        public void setPrevious(Node<T> newPreviousNode) {
            next = newPreviousNode;
        }
    }
}