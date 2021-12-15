public class Main {
    public static int transition(int[] a){
        int s=0;
        int e=a.length-1;
       
        while(s<=e){
            int mid=(s+e)/2;
            if(a[mid]==0){
           s=mid+1;
            }
            else {
                if(mid==0){
                    return 0;// this is to handle the case when all array elements are 1
                }
            
            else if((mid-1)>=0 && a[mid-1]==0){
                return mid;
            }
            else{
                e=mid-1;
            }
        }}
        return -1;
        
    }

	
	public static void main(String[] args) {
	

		// Write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        
        int ans=transition(a);
        System.out.println(ans);
     

	}

}
