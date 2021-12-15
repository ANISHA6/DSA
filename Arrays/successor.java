public class Main {
    
    public static int length(int n){
        
        int i=0;
        while(n>0){
            i++;
            n/=10;
        }
        return i;
    }
    public static int[] numToarray(int n){
        int l=length(n);
        
        int a[]=new int[l];
        for(int i=l-1;i>=0;i--){
            a[i]=n%10;
            n/=10;
        }
        return a;
    }
public static void findsuccessor(int[] a){
    int l=a.length;
    if(l==1){
        return;
    }
    
    int i=l-2;
    while(i>=0){
        if(a[i+1]>a[i]){
            break;
        }
        i--; //265410, find index of 2
    }
    // if i becomes -1 i.e it is the max element so we just have to reverse it, to find first or original element
    if(i!=-1){
        int k=i+1;
        for(int j=i+1;j<l;j++){
            if(a[j]>a[i] && a[j]<a[k]){
                k=j;
            }
        }
        int t=a[i];// Replace 2 to 4, 465210
        a[i]=a[k];
        a[k]=t;
    }
    Arrays.sort(a,i+1,l);// Reversing 65210-> 01256
}
    
    public static int arrayToNum(int[] a){
        int n=a.length;
        int num=0;
        for(int i=0;i<n;i++){
            num=num*10+a[i];
        }
        return num;
    }
	
	public static void main(String[] args) {
		// Write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=numToarray(n);
        findsuccessor(a);// Just next greater no of given no (from all permutation)
        int ans=arrayToNum(a);
        System.out.println(ans);
        
                                             
      
      
	}

}
