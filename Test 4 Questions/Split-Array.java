public class solution {
    public static boolean helper(int arr[],int n,int start,int lsum,int rsum){
        
        if(start==n){
            return lsum==rsum;
        }
        if(arr[start]%5==0)
            lsum+=arr[start];
        else if(arr[start]%3==0)
            rsum+=arr[start];
        else{
            //put the value in any group if not divisible by 3 and 5
            return helper(arr,n,start+1,lsum+arr[start],rsum)|| helper(arr,n,start+1,lsum,rsum+arr[start]);
            
            }
        return helper(arr,n,start+1,lsum,rsum);//for, who is divisible by 3 or 5
    }

	public static boolean splitArray(int input[]) {
		/* Your class should be named solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/
		
       int l=input.length;
        return helper(input,l,0,0,0);
	}
	
