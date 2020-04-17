package DLL;

public class DoubleLinkedListTester {

    public static void main(String[] args) {
        
        DoubleLinkedList<Integer> listOfIntegers = new DoubleLinkedList<Integer>();
        int user_choice = 0;
        
        do
        {
            System.out.println("Double Linked List Tester Menu\n");
            System.out.println("1. Test insertFront");
            System.out.println("2. Test insertBack");
            System.out.println("3. Test insertAt");
            System.out.println("4. Test removeFront");
            System.out.println("5. Test removeBack");
            System.out.println("6. Test removeAt");
            System.out.println("7. Test toString");
            System.out.println("8. Test isEmpty");
            System.out.println("9. Test getSize");
            System.out.println("0. Quit Test Program");
            System.out.println("Enter an option (1-9, or 0): ");
            user_choice = new java.util.Scanner(System.in).nextInt();
            
            if (user_choice == 0 ) break;
            if (user_choice == 1 )
            {
                System.out.print("Enter an integer to insert: ");
                int value = new java.util.Scanner(System.in).nextInt();
                listOfIntegers.insertFront(value);
            }
            if (user_choice == 2 )
            {
                System.out.print("Enter an integer to insert: ");
                int value = new java.util.Scanner(System.in).nextInt();
                listOfIntegers.insertBack(value);
            }
            if (user_choice == 3 )
            {
                System.out.print("Enter an integer to insert: ");
                int value = new java.util.Scanner(System.in).nextInt();
                System.out.print("Enter index position to insert at: ");
                int position = new java.util.Scanner(System.in).nextInt();
                listOfIntegers.insertAt(value,position);
            }
            if (user_choice == 4 )
            {                
                int value = listOfIntegers.removeFront();
                System.out.println("Remove node from front, node had the value: "+value);
            }
            if (user_choice == 5 )
            {
                int value = listOfIntegers.removeBack();
                System.out.println("Remove node from back, node had the value: "+value);
            }
            if (user_choice == 6 )
            {
                System.out.print("Enter index position to remove at: ");
                int position = new java.util.Scanner(System.in).nextInt();
                int value = listOfIntegers.removeAt(position);
                System.out.println("Remove node from front, node had the value: "+value);
            }
            if (user_choice == 7 )
            {
                System.out.println("toString returned: ");
                System.out.println(listOfIntegers.toString());
            }
            if (user_choice == 8 )
            {
                System.out.println("isEmpty returned: "+listOfIntegers.isEmpty());
            }
            if (user_choice == 9 )
            {
                System.out.println("getSize returned: "+listOfIntegers.getSize());
            }
        } while(true);
    }
    
}
