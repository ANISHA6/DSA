public class Solution {
    public static int partition(int[] a,int s,int e){
        
        
        int pivot=a[s];
        
        int countsmall=0;
        for(int i=s+1;i<=e;i++){
            if(a[i]<=pivot){
                countsmall++; //Count the elements smaller than pivot
            }
        }
        int temp=a[s+countsmall]; //shift pivot to right place
        a[s+countsmall]=pivot;
        a[s]=temp;
       // return s+countsmall
            
        int i=s;
        int j=e;
        while(i<j){
            if(a[i]<=pivot){
                i++;
            }
            else if(a[j]>pivot){
                j--;
            }
            else{
                int t=a[i]; //swap a[i] to a[j] , to make all elements left side smaller than pivot
                a[i]=a[j]; // and right side greater than pivot
                a[j]=t;
                i++;
                j--;
            }
        }
        return s+countsmall; // Return pivot index so that we can sort
        //the elements before and after the pivot element
    }
    public static void qs(int[] a,int s, int e){
        if(s>=e){
            return;
        }
        int j=partition(a,s,e); // find right index for pivot element
        qs(a,s,j-1); // sort elements before pivot element
        qs(a,j+1,e); // sort elements after pivot element
    }
	
	public static void quickSort(int[] input) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * No need to print or return the output.
		 * Taking input and printing output is handled automatically.
         
		 */
        
       qs(input,0,input.length-1);
		
	}
	
}
