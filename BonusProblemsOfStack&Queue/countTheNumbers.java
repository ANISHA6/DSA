
class Solution {
    public static boolean isSmallest(int n){
        int preDigit=9;
        while(n>0){
            int currDigit=n%10;
            if(currDigit>preDigit)
                return false;
            preDigit=currDigit;
            n/=10;
        }
        return true;
    }
    public static int permutations(int n) {
        //Write your code here
         if(n<=9){
            return n;
        }
        //Method1
        Stack<Integer> st=new Stack<>();
        if(n>9){
            int i=1;
            while(i<10){
         
            st.push(i);//Inserting 1 to 9 into stack
            i++;
        }
  }
        int count=9;
        while(!st.isEmpty()){
            int x=st.pop();
            int sd=x%10;//For getting last digit
            //count++;
            for(int i=1;i<10;i++){
                if(i>=sd){//if i greater then last digit then only make it last digit
                    int y=x*10+i;
                    if(y<=n){
                    count++;
                    st.push(y);}
                }
            }
        }
        return count;
        
        //Method 2
        
        int ret=0;
        for(int i=1;i<=n;i++){
            if(isSmallest(i))
                ret++;
        }
        return ret;
    }
}
