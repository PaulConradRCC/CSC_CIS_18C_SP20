package DLL;

public class DoubleLinkedList<T> implements DoubleLinkedListInterface<T> {
    
    private DNode<T> head;  // head is the front of the linked list
    private DNode<T> tail;  // tail is the end of the linked list
    private int listCount; // utility variable to keep track of # of items in the list
    
    // check to see if the linked list is empty
    public boolean isEmpty() {
        return ( listCount == 0 );
    }
    
    // get the size of the linked list
    public int getSize() {
        return listCount;
    }
    
    // insertFront, insertBack, insertAt functions
    public void insertFront(T item) {
        DNode new_node = new DNode<>(item); // create our new node
        
        // if head is null, then the new node we created is the head and the tail to start the linked list
        if ( head == null )
        {
            head = new_node;
            tail = head;
        }
        else
        {
            new_node.setNextNode( head );   // the new_node next node now points or references to head
            head.setPreviousNode(new_node); // we need to have old head point to new_node in previous
            head = new_node;            // once the link has been updated, the new_node becomes the new head
        }
        
        listCount++;  // we added a node, update the list count
    }
    
    public void insertBack(T item) {
        DNode new_node = new DNode<>(item); // create our new node
        
        // if head is null, then the new node we created is the head and the tail to start the linked list
        if ( head == null )
        {
            head = new_node;
            tail = head;
        }
        else
        {
            tail.setNextNode( new_node );   // the current tails next node now points or references to new_node
            new_node.setPreviousNode(tail); // we need to have new_node's previous point to old tail
            tail = new_node;            // once the link has been updated, the new_node becomes the new tail
        }
        
        listCount++;  // we added a node, update the list count
    }
    
    public void insertAt(T item, int position) {
        if ( position < 0 )
        {
            throw new IllegalArgumentException("Position cannot be less than zero.");  // O(1)
        }
        else if ( position == 0 )
        {
            insertFront( item );  // O(1)
        }
        else if ( position >= listCount )
        {
            insertBack( item );  // O(1)
        }
        else
        {
            // O(n) due to traversing to find the insertion point in the single linked list
            DNode current = head;
            
            for(int i=0; i<position; i++)
            {
                current = current.getNextNode();
            }
            
            DNode new_node = new DNode<>( item );
            current.getNextNode().setPreviousNode(new_node);
            new_node.setNextNode(current.getNextNode());
            current.setNextNode(new_node);
            new_node.setPreviousNode(current);
        }
        
        listCount++;
    }
    
    // removeFront, removeBack, removeAt functions
    public T removeFront() {
        return null;
    }
    public T removeBack() {
        return null;
    }
    public T removeAt(int position) {
        return null;
    }
    
    // toString function to output our double linked list
    public String toString() {
        String s="";
        
        DNode current = head;
        
        while ( current != null )
        {
            s = s + " [" + current.getData().toString() + "]";
            current = current.getNextNode();
        }
        
        return s;
    }
    ///////////////////////////////////////////////////////////////////////////
    private class DNode<T>
    {
        private T data;
        private DNode<T> next, previous;
        
        // constructors
        public DNode()
        {
            next = null;
            previous = null;
            data = null;
        }
        
        public DNode(T dataValue)
        {
            next = null;
            previous = null;
            data = dataValue;
        }
        
        public DNode(T dataValue, DNode nextNode, DNode previousNode)
        {
            data = dataValue;
            next = nextNode;
            previous = previousNode;
        }
        
        // setters for the next and previous nodes
        public void setNextNode(DNode newNext)
        {
            next = newNext;
        }
        
        public void setPreviousNode(DNode newPrevious)
        {
            previous = newPrevious;
        }
        
        // getters for the next and previous nodes
        public DNode getNextNode()
        {
            return next;
        }
        
        public DNode getPreviousNode()
        {
            return previous;
        }
        
        // getter and setter for data element
        public T getData()
        {
            return data;
        }
        
        public void setData(T dataValue)
        {
            data = dataValue;
        }
    }
}
