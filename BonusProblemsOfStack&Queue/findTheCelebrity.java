
class Solution {
    public static boolean knows(int[][] arr, int i, int j ){
        if(arr[i][j]==1){
            return true;
        }
        else
            return false;
    } 
   
    public static int celebrity(int[][] arr, int n) {
        //Write your code here
        Stack<Integer> st=new Stack<Integer>();
        for(int i=0;i<n;i++){//Putting all the people into the stack
            st.push(i);
        }
        while(st.size()>1){
            int val1=st.pop();
            int val2=st.pop();
            if(knows(arr,val1, val2)){//Al last, only one person will left in stack that may or
                st.push(val2); //may not be a celebrity
            }
            else
                st.push(val1);
        }
        int c=st.pop();//Popped that one left person
        for(int i=0;i<n;i++){
            if(i!=c &&(knows(arr,c,i) ||!knows(arr,i,c))){
                return -1; //if c knows i i.e c is not a celebrity
            }              // Or if i doesn't know c i.e c is not a celebrity
                         // then return -1
        }
        return c;
    }
}
