import java.util.*;
public class Solution {

	public static boolean checkRedundantBrackets(String expression) {
		//Your code goes here
        int l=expression.length();
        if(l==0){
            return false;
        }
        
        Stack<Character> stack=new Stack<>();
        int c=0;
        for(int i=0;i<l;i++){
            if(expression.charAt(i)!=')'){
                stack.push(expression.charAt(i));
            }
            else{
                while(!stack.isEmpty() && stack.peek()!='('){
                    c++;
                    stack.pop();
                }
                if(stack.peek()=='('){
                    stack.pop();
                    if(c>1){
                        if(stack.isEmpty() && i==l-1){
                            c=0;
                            return false;
                        }
                        else{
                        c=0;
                        }
                    }
                    else{
                        return true;
                    }
                }
                
                }
            }
        
        
       if(!stack.isEmpty() && c==0){
           return false;
        }
        
        return true;
	}
}
