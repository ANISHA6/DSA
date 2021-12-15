import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            
        }
        
        int peakindex=0;
       
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(a[i]>max){
                max=a[i];
                peakindex=i; // Index of max height 
            }
           
        }
        // Left to right till max height
        int currentPeak=a[0];
        int sum=0;
        for(int i=1;i<peakindex;i++){
            if(a[i]<currentPeak){
                sum+=currentPeak-a[i];
            }
            else {
                currentPeak=a[i];
            }
        }
        // Right to left till max height
        int cp=a[n-1];
        if(peakindex<n){
        for(int i=n-2;i>peakindex;i--){
            if(a[i]<cp){
                sum+=cp-a[i];
            }
            else{
                cp=a[i];
            }
        }
    }
        System.out.println(sum);
        

	}

}
