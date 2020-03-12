package bubblesort;

public class BubbleSort {

    public static void main(String[] args) {

        java.util.Scanner kb = new java.util.Scanner(System.in);
        
        System.out.print("Enter number of elements for array: ");
        int num_elements = kb.nextInt();
        
        if ( num_elements <= 0 )
        {
            System.out.println("Must be a positive number of elements!");            
        }
        else
        {
            int [] arr = new int[num_elements];
            
            for(int i=0; i<num_elements; i++)
            {
                System.out.printf("Enter value for arr[%d]: ",i);
                arr[i] = kb.nextInt();
            }
            
            System.out.println("\nOriginal array contents:");
            display_array(arr); 
            System.out.printf("\n");
            
            bubblesort(arr,true,true);
            
            System.out.printf("\nArray after bubblesort (ascending):");
            display_array(arr);
            System.out.printf("\n");
            
            bubblesort(arr,false,true);
            
            System.out.printf("\nArray after bubblesort (ascending):");
            display_array(arr);
            System.out.printf("\n");
        }
    }
    
    public static void display_array(int [] a)
    {
        for(int i=0; i<a.length-1; i++)
            System.out.print(a[i]+", ");
        System.out.print(a[a.length-1]);
    }
    
    public static boolean swap(int [] a, int i)
    {
        if ( i > a.length-1 )
            return false;
        int temp = a[i];
        a[i] = a[i+1];
        a[i+1] = temp;
        return true;
    }
    public static void bubblesort(int [] a, boolean sort_ascending, boolean analysis)
    {
        boolean swapped; // if two elements are swapped, true, else false
        int comparisons = 0;
        
        do {
            swapped = false;
            
            for(int i=0; i < a.length-1; i++)
            {
                // for ascending order, smallest to largest
                if ( sort_ascending )
                {
                    comparisons++;
                    if ( a[i] > a[i+1] )
                    {
                        swapped = swap(a,i);
                    }
                }
                else
                {
                    comparisons++;
                    if ( a[i] < a[i+1] )
                    {
                        swapped = swap(a,i);
                    }
                }
            }
        } while (swapped); // repeat while swapped == true
        
        if ( analysis == true )
            System.out.printf("It took %d of comparisons to sort the array.\n",
                       comparisons);
    }
}
