public class Solution {

	public static int[] stockSpan(int[] price) {

Stack<Integer> stack=new Stack<>();
        int[] ans=new int[price.length];
        stack.push(0);
        ans[0]=1;
        //We are pushing index into the stack
        for(int i=1;i<price.length;i++){

                while(!stack.isEmpty() &&price[i]>price[stack.peek()] ){
                    stack.pop();  
                }
                if(stack.isEmpty()){//for first element and if last element is grater than previous elememt
                    ans[i]=i+1;
                }
                else{
                    ans[i]=i-stack.peek();
                    
                }
            
            stack.push(i);
        }
            
         return ans;
         
	}

}
