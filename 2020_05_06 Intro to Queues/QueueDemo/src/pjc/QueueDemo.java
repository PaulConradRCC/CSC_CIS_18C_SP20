package pjc;

public class QueueDemo {

    public static void main(String[] args) {
        QueueIntegers queueOfIntegers = new QueueIntegers();
        int user_choice = 0;
        
        do
        {
            System.out.println("QueueInteger Tester Menu\n");
            System.out.println("1. Test Enqueue / Push_Back");
            System.out.println("2. Test Front / Peek_Front, Back / Peek_Back");
            System.out.println("3. Test Dequeue / Pop_Front");
            System.out.println("4. Test isEmpty");
            System.out.println("5. Test Clear");
            System.out.println("6. Test toString (non-verbose)");
            System.out.println("7. Test toString (verbose)");
            System.out.println("0. Quit Test Program");
            System.out.println("Enter an option (1-7, or 0): ");
            user_choice = new java.util.Scanner(System.in).nextInt();
            
            if (user_choice == 0 ) break;
            
            if (user_choice == 1 )
            {
                System.out.print("Enter an integer to enqueue / push_back: ");
                int value = new java.util.Scanner(System.in).nextInt();
                queueOfIntegers.enqueue(value);
            }
            
            if (user_choice == 2 )
            {
                try {
                    System.out.printf("Value at front of queue is: %d%n", queueOfIntegers.front()); 
                    System.out.printf("Value at back of queue is: %d%n", queueOfIntegers.back()); 
                }
                catch(RuntimeException e)
                {
                    System.out.printf("Exception thrown: %s%n", e.getMessage());                            
                }
            }
            
            if (user_choice == 3 )
            {
                try {
                    System.out.printf("Value removed from front of queue is: %d%n", queueOfIntegers.dequeue());
                }
                catch(RuntimeException e)
                {
                    System.out.printf("Exception thrown: %s%n", e.getMessage());                            
                }
            }
            
            if (user_choice == 4 )
            {                
                System.out.printf("queueOfInteger is empty? %b%n", queueOfIntegers.isEmpty());
            }
            
            if (user_choice == 5 )
            {
                queueOfIntegers.clear();
                System.out.printf("queueOfInteger is empty? %b%n", queueOfIntegers.isEmpty());
            }
            
            if (user_choice == 6 )
            {
                System.out.printf("queueOfIntegers.toString returned: %n%n%s%n%n", queueOfIntegers.toString());
            }
            
            if (user_choice == 7 )
            {
                System.out.printf("queueOfIntegers.toString returned: %n%n%s%n%n", queueOfIntegers.toString(true));
            }
            
        } while(true);
    }
    
}
