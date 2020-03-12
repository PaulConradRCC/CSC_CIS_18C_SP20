package mergesort;

public class MergeSort {

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
            
            mergesort(arr,true,true);
            
            System.out.printf("\nArray after bubblesort (ascending):");
            display_array(arr);
            System.out.printf("\n");
            
            mergesort(arr,false,true);
            
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
    
    // Merges two subarrays of arr[]. 
    // First subarray is arr[l..m] 
    // Second subarray is arr[m+1..r] 
    public void merge(int arr[], int l, int m, int r) 
    { 
        int i, j, k; 
        int n1 = m - l + 1; 
        int n2 = r - m; 

        /* create temp arrays */
        int L[n1], R[n2]; 

        /* Copy data to temp arrays L[] and R[] */
        for (i = 0; i < n1; i++) 
                L[i] = arr[l + i]; 
        for (j = 0; j < n2; j++) 
                R[j] = arr[m + 1+ j]; 

        /* Merge the temp arrays back into arr[l..r]*/
        i = 0; // Initial index of first subarray 
        j = 0; // Initial index of second subarray 
        k = l; // Initial index of merged subarray 
        while (i < n1 && j < n2) 
        { 
                if (L[i] <= R[j]) 
                { 
                        arr[k] = L[i]; 
                        i++; 
                } 
                else
                { 
                        arr[k] = R[j]; 
                        j++; 
                } 
                k++; 
        } 

        /* Copy the remaining elements of L[], if there 
        are any */
        while (i < n1) 
        { 
                arr[k] = L[i]; 
                i++; 
                k++; 
        } 

        /* Copy the remaining elements of R[], if there 
        are any */
        while (j < n2) 
        { 
                arr[k] = R[j]; 
                j++; 
                k++; 
        } 
    } 

    public static void mergesort(int [] arr, boolean sort_ascending, boolean analysis)
    {
        mergeSortHelper(arr, 0, arr.length-1, sort_ascending, analysis);
    }
    
    /* l is for left index and r is right index of the 
    sub-array of arr to be sorted */
    public static void mergeSortHelper(int [] arr, int l, int r, boolean sort_ascending, boolean analysis) 
    { 
        if (l < r) 
        { 
                // Same as (l+r)/2, but avoids overflow for 
                // large l and h 
                int m = l+(r-l)/2; 

                // Sort first and second halves 
                mergeSortHelper(arr, l, m,sort_ascending, analysis); 
                mergeSortHelper(arr, m+1, r, sort_ascending, analysis); 

                merge(arr, l, m, r); 
        } 
    } 
}
