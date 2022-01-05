 public class Solution {
static int getMaxArea(int[] array, int n) {
int i=0;
        int maxArea=0;
        Stack<Integer> stack=new Stack<Integer>();
        while(i<n){
            if(stack.isEmpty()|| array[i]>=array[stack.peek()]){
                stack.push(i);
                i++;
            }
            else{// if current bar is smaller than previous bar that is it is creating the obstacle
                int top=stack.pop();// so calculate its area
                int a=array[top]*(stack.isEmpty()?i:i-stack.peek()-1);
                maxArea=Math.max(a,maxArea);
                
                
            }
        }
        while(!stack.isEmpty()){
            int top=stack.pop();
                int a=array[top]*(stack.isEmpty()?i:i-stack.peek()-1);
                maxArea=Math.max(a,maxArea); // Width=Rindex-Lindex-1
                
        }
        return maxArea;
        
        
	}

}
