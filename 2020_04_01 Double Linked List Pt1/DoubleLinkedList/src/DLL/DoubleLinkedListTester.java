package DLL;

public class DoubleLinkedListTester {

    public static void main(String[] args) {
        
        DoubleLinkedList<Integer> listOfIntegers = new DoubleLinkedList<Integer>();
        
        // add a node with 100 to the front
        listOfIntegers.insertFront(100);
        System.out.println("Inserted 100 to front: "+listOfIntegers.toString());
        
        // add a node with 75 to the front
        listOfIntegers.insertFront(75);
        System.out.println("Inserted 75 to front: "+listOfIntegers.toString()); // should be: [75] [100]
        
        // add a node with 200 to the back
        listOfIntegers.insertBack(200);
        System.out.println("Inserted 200 to back: "+listOfIntegers.toString()); // should be: [75] [100] [200]
        
        // add a node with 175 between 100, and 200
        listOfIntegers.insertAt(175,1);
        System.out.println("Inserted 175 after 'index 1': "+listOfIntegers.toString()); // should be: [75] [100] [175] [200]
        
    }
    
}
