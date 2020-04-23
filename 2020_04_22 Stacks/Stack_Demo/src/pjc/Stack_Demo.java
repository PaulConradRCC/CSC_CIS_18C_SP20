package pjc;

public class Stack_Demo {
    public static void main(String[] args) {
        
        StackInt stackOfIntegers = new StackInt();
        int user_choice = 0;
        
        do
        {
            System.out.println("StackInt Tester Menu\n");
            System.out.println("1. Test Push");
            System.out.println("2. Test Peek");
            System.out.println("3. Test Pop");
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
                System.out.print("Enter an integer to push onto stack: ");
                int value = new java.util.Scanner(System.in).nextInt();
                stackOfIntegers.push(value);
            }
            
            if (user_choice == 2 )
            {
                try {
                    System.out.printf("Value at top of the stack is: %d%n", stackOfIntegers.peek());            
                }
                catch(RuntimeException e)
                {
                    System.out.printf("Exception thrown: %s%n", e.getMessage());                            
                }
            }
            
            if (user_choice == 3 )
            {
                try {
                    System.out.printf("Value popped off the stack is: %d%n", stackOfIntegers.pop());
                }
                catch(RuntimeException e)
                {
                    System.out.printf("Exception thrown: %s%n", e.getMessage());                            
                }
            }
            
            if (user_choice == 4 )
            {                
                System.out.printf("stackOfInteger is empty? %b%n", stackOfIntegers.isEmpty());
            }
            
            if (user_choice == 5 )
            {
                stackOfIntegers.clear();
                System.out.printf("stackOfInteger is empty? %b%n", stackOfIntegers.isEmpty());
            }
            
            if (user_choice == 6 )
            {
                System.out.printf("stackOfIntegers.toString returned: %n%n%s%n%n", stackOfIntegers.toString());
            }
            
            if (user_choice == 7 )
            {
                System.out.printf("stackOfIntegers.toString returned: %n%n%s%n%n", stackOfIntegers.toString(true));
            }
            
        } while(true);
    }
}
