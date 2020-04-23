package pjc;

public class StackInt {

    private StackNode top;
    
    public StackInt()
    {
        top = null;
    }
    
    public void push(int dataValue)
    {
        StackNode new_top = new StackNode( dataValue, top );
        top = new_top;
    }
    
    public int peek()
    {
        if ( isEmpty() )
            throw new RuntimeException("Attempted to peek at an empty stack");
        return top.getData();
    }

    public int pop()
    {
        int value = 0;
        try {
            value = peek();
        }
        catch(RuntimeException e)
        {
            throw new RuntimeException("Attempted to pop value off an empty stack");
        }
        top = top.getNext();
        return value;
    }
    
    public boolean isEmpty()
    {
        return ( top == null );
    }
    
    public void clear()
    {
        top = null;
    }
    
    @Override
    public String toString()
    {
        StackNode current = top;
        String result = "";
              
        if ( current == null )
        {
            result = "[Empty Stack]";
        }
        else
        {
            while ( current != null )
            {
                result = result + "[" + current.data + "] ";
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
            if ( !result.equals("[Empty Stack]") )
                result = "((TOP)) " + result + "((BOTTOM))";
        }
        
        return result;
    }
    
    // private inner class for node
    private class StackNode {
        private StackNode next;
        private int data;
        
        // constructor
        public StackNode(int dataValue, StackNode nextNode)
        {
            next = nextNode;
            data = dataValue;
        }
        
        // get for next and data
        public StackNode getNext()
        {
            return next;
        }
        
        public int getData()
        {
            return data;
        }
    }
}
