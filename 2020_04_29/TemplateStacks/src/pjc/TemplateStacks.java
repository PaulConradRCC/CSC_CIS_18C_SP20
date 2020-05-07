package pjc;

public class TemplateStacks {

    public static void main(String[] args) {
        Stack<String> ourTestStack = new Stack<String>();
        // when you change the template type in line 6, make sure to adjust line 31's type
        // for the variable value and the Scanner as needed.
        
        int user_choice = 0;
        
        do
        {
            System.out.println("Stack Tester Menu\n");
            System.out.println("1. Test Push");
            System.out.println("2. Test Peek");
            System.out.println("3. Test Pop");
            System.out.println("4. Test isEmpty");
            System.out.println("5. Test Clear");
            System.out.println("6. Test toString (non-verbose)");
            System.out.println("7. Test display");
            System.out.println("0. Quit Test Program");
            System.out.println("Enter an option (1-7, or 0): ");
            user_choice = new java.util.Scanner(System.in).nextInt();
            
            if (user_choice == 0 ) break;
            
            if (user_choice == 1 )
            {
                System.out.print("Enter a data value to push onto stack: ");
                String value = new java.util.Scanner(System.in).nextLine();
                ourTestStack.push(value);
            }
            
            if (user_choice == 2 )
            {
                try {
                    System.out.printf("Value at top of the stack is: %s%n", ourTestStack.peek().toString() );            
                }
                catch(RuntimeException e)
                {
                    System.out.printf("Exception thrown: %s%n", e.getMessage());                            
                }
            }
            
            if (user_choice == 3 )
            {
                try {
                    System.out.printf("Value popped off the stack is: %s%n", ourTestStack.pop().toString() );
                }
                catch(RuntimeException e)
                {
                    System.out.printf("Exception thrown: %s%n", e.getMessage());                            
                }
            }
            
            if (user_choice == 4 )
            {                
                System.out.printf("ourTestStack is empty? %b%n", ourTestStack.isEmpty());
            }
            
            if (user_choice == 5 )
            {
                ourTestStack.clear();
                System.out.printf("Did clear work? ourTestStack should be empty... %b%n", ourTestStack.isEmpty());
            }
            
            if (user_choice == 6 )
            {
                System.out.printf("ourTestStack.toString returned: %n%n%s%n%n", ourTestStack.toString());
            }
            
            if (user_choice == 7 )
            {
                System.out.printf("Output of ourTestStack.display() returned: %n%n");
                ourTestStack.display();
                System.out.println();
            }
            
        } while(true);
    }
}
