import java.util.Scanner;
import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here
        // Self
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); // No of chocolate cartoon
       // int m=sc.nextInt();
        int[] c=new int[n];
        for(int i=0;i<n;i++){
            c[i]=sc.nextInt();
        }
        int m=sc.nextInt();// No of students.
        //n>=m
        Arrays.sort(c);
        int i=0;// Here min no of chocolates is present
        int j=i+m-1; // Here max no of chocolates is present
        int min=Integer.MAX_VALUE;
        while(j<n){
            int mind=c[j]-c[i];// Calculating min no of diff 
            if(mind<min){
                min=mind;
            }
            i++;
            j++;
        }
        System.out.print(min);

	}

}
