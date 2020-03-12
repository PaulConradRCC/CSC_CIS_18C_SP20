public class Big_O_n {

    public static void main(String[] args) {
	int s1_steps = 0, s2_steps=0, s3_steps=0;
	int N;

	System.out.print("Enter an integer value for N: ");
	N = new java.util.Scanner(System.in).nextInt();

	int s=0; s1_steps++; // S1
    	for(int i=1; i<=N; i++) // S2
        {
            s2_steps++; // count the times i<=N is true
            s=s+i; s3_steps++; // S3
        }
        s2_steps++; // count the one time i<=N is false

	System.out.printf("S1 executed %d%n",s1_steps);	
        System.out.printf("S2 executed %d%n",s2_steps);	
        System.out.printf("S3 executed %d%n",s3_steps);	
    }    
}