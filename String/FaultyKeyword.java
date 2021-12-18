public class Solution {
    
    public static void check(String name, String typed){
        
        int l1=name.length();
        int l2=typed.length();
        if(l1>l2){
            System.out.println("false");
            return;
        }
        
        int i=0;
        int j=0;
        while(i<l1 && j<l2){
            if(name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            }
            else if(i>0 && name.charAt(i-1)==typed.charAt(j)){
                j++;
            }
            else{
                System.out.println("false");
                return;}
        }
        
        while(j<l2){
            if(name.charAt(i-1)!=typed.charAt(j)){
                System.out.println("false");
                return;
            }
            else 
                j++;
        }
        if(i<l1){
            System.out.println("false");
            return;
        }
        else{
            System.out.println("true");
            return;
        }
        
    }
    public static void main(String[] args) {
		// Write your code here
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        for(int i=1;i<=N;i++){
            String first=sc.next();
            String second=sc.next();
            check(first,second);
        }
        
        
    }
}
