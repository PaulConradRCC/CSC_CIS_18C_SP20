package pjc;

public class DequeDemo {

public static void main(String[] args) {
        Deque<String> dequeStrings = new Deque();
        int user_choice = 0;
        
        do
        {
            System.out.println("Deque String Tester Menu\n");
            System.out.println("1. Test Enqueue_Front / Push_Front");
            System.out.println("2. Test Enqueue_Back / Push_Back");
            System.out.println("3. Test Front, Back");
            System.out.println("4. Test Dequeue_Front / Pop_Front");
            System.out.println("5. Test Dequeue_Back / Pop_Back");
            System.out.println("6. Test isEmpty");
            System.out.println("7. Test Clear");
            System.out.println("8. Test toString (non-verbose)");
            System.out.println("9. Test toString (verbose)");
            System.out.println("0. Quit Test Program");
            System.out.println("Enter an option (1-9, or 0): ");
            user_choice = new java.util.Scanner(System.in).nextInt();
            
            if (user_choice == 0 ) break;
            
            if (user_choice == 1 ) {
                System.out.print("Enter a string to enqueue front / push front: ");
                String value = new java.util.Scanner(System.in).nextLine();
                dequeStrings.push_front(value);
            }
            
            if (user_choice == 2 ) {
                System.out.print("Enter a string to enqueue back / push back: ");
                String value = new java.util.Scanner(System.in).nextLine();
                dequeStrings.push_back(value);
            }
            
            if (user_choice == 3 ) {
                try {
                    System.out.printf("Value at front of deque is: %s%n", dequeStrings.front()); 
                    System.out.printf("Value at back of deque is: %s%n", dequeStrings.back()); 
                }
                catch(RuntimeException e) {
                    System.out.printf("Exception thrown: %s%n", e.getMessage());                            
                }
            }
            
            if (user_choice == 4 ) {
                try {
                    System.out.printf("Value removed from front of deque is: %s%n", dequeStrings.pop_front());
                }
                catch(RuntimeException e) {
                    System.out.printf("Exception thrown: %s%n", e.getMessage());                            
                }
            }
            
            if (user_choice == 5 ) {
                try {
                    System.out.printf("Value removed from back of deque is: %s%n", dequeStrings.pop_back());
                }
                catch(RuntimeException e) {
                    System.out.printf("Exception thrown: %s%n", e.getMessage());                            
                }
            }
            
            if (user_choice == 6 )
            {                
                System.out.printf("dequeStrings is empty? %b%n", dequeStrings.isEmpty());
            }
            
            if (user_choice == 7 )
            {
                dequeStrings.clear();
                System.out.printf("dequeStrings is empty? %b%n", dequeStrings.isEmpty());
            }
            
            if (user_choice == 8 )
            {
                System.out.printf("dequeStrings.toString returned: %n%n%s%n%n", dequeStrings.toString());
            }
            
            if (user_choice == 9 )
            {
                System.out.printf("dequeStrings.toString returned: %n%n%s%n%n", dequeStrings.toString(true));
            }
            
        } while(true);
    }
}
