public class Big_O_n2 {
public static void main(String[] args) {
	int s1_steps = 0, s2_steps=0, s3_steps=0, s4_steps=0;
	int N;

	System.out.print("Enter an integer value for N: ");
	N = new java.util.Scanner(System.in).nextInt();

	int s=0; s1_steps++; // S1
	for(int i=1; i<=N; i++) // S2
        {
            s2_steps++; // count the times i<=N is true
            for(int j=1; j<=N; j++) //S3
            {
                s3_steps++; // count the times j<=N is true
                s=s+i; s4_steps++; // S4
            }
            s3_steps++; // count the one time j<=N is false
        }
        s2_steps++; // count the one time i<=N is false

	System.out.printf("S1 executed %d%n",s1_steps);	
        System.out.printf("S2 executed %d%n",s2_steps);	
        System.out.printf("S3 executed %d%n",s3_steps);	
        System.out.printf("S4 executed %d%n",s4_steps);	
    } 
    
}
