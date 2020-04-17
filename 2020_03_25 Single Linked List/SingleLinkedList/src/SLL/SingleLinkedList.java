package SLL;

public class SingleLinkedList<T extends Object> {
    
    private Node head;  // head is the front of the linked list
    private Node tail;  // tail is the end of the linked list
    private int listCount; // utility variable to keep track of # of items in the list
    
    public SingleLinkedList()
    {
        head = null;
        tail = null;
        listCount = 0;        
    }
    
    public void add_tail(T dataValue)
    {
        Node new_node = new Node(dataValue); // create our new node
        
        // if head is null, then the new node we created is the head and the tail to start the linked list
        if ( head == null )
        {
            head = new_node;
            tail = head;
        }
        else
        {
            tail.setNextNode( new_node );   // the current tails next node now points or references to new_node
            tail = new_node;            // once the link has been updated, the new_node becomes the new tail
        }
        
        listCount++;  // we added a node, update the list count
    }
    
    public void add_head(T dataValue)
    {
        Node new_node = new Node(dataValue); // create our new node
        
        // if head is null, then the new node we created is the head and the tail to start the linked list
        if ( head == null )
        {
            head = new_node;
            tail = head;
        }
        else
        {
            new_node.setNextNode( head );   // the new_node next node now points or references to head
            head = new_node;            // once the link has been updated, the new_node becomes the new head
        }
        
        listCount++;  // we added a node, update the list count
    }
    
    public void insertAt(T dataValue, int position)
    {
        if ( position < 0 )
        {
            throw new IllegalArgumentException("Position cannot be less than zero.");  // O(1)
        }
        else if ( position == 0 )
        {
            add_head( dataValue );  // O(1)
        }
        else if ( position > listCount )
        {
            add_tail( dataValue );  // O(1)
        }
        else
        {
            // O(n) due to traversing to find the insertion point in the single linked list
            Node previous = null;
            Node current = head;
            
            for(int i=0; i<position; i++)
            {
                previous = current;
                current = current.getNextNode();
            }
            
            Node new_node = new Node( dataValue );
            previous.setNextNode( new_node );
            new_node.setNextNode( current );            
        }
        
        listCount++;
    }
    
    public T remove_head()
    {
        if ( head == null )
            return (T)null;
        
        Node old_head = head;
        T old_data = (T)head.getData();
        head = head.getNextNode();
        old_head = null;
        
        listCount--;
        
        return old_data;    
    }
    
    public T remove_tail()
    {
        if ( tail == null )
            return (T)null;
        
        Node previous = null;
        Node current = head;
        
        while ( current != tail )
        {
            previous = current;
            current = current.getNextNode();
        }
        
        Node old_tail = current;
        T old_data = (T)current.getData();
        tail = previous;
        tail.setNextNode(null);
        
        listCount--;
        
        return old_data;
    }
    
    public int size()
    {
        return listCount;
    }
    
    @Override
    public String toString()
    {
        Node current = head;
        String output = "";
        while( current != null )
        {
            output += "[" +current.getData().toString() + "] ";
            current = current.getNextNode();
        }
        
        return output;
    }
    
    //////////////////////////////////////////////////////////////////////////
    
    private class Node<T>
    {
        private Node next;
        private T data;
        
        public Node()
        {
            next = null;
            data = null;
        }
        
        public Node(T dataValue)
        {
            next = null;
            data = dataValue;
        }
        
        public Node(T dataValue, Node nextNode)
        {
            next = nextNode;
            data = dataValue;
        }
        
        public T getData()
        {
            return data;
        }
        
        public void setData(T dataValue)
        {
            data = dataValue;
        }
        
        public Node getNextNode()
        {
            return next;
        }
        
        public void setNextNode(Node nextNode)
        {
            next = nextNode;
        }
    }
}
