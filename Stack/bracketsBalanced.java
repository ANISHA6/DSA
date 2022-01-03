import java.util.*;
public class Solution {

    public static boolean isBalanced(String expression) {
        //Your code goes here
        if(expression.length()==0){
            return true;
        }
        
        Stack<Character> stack=new Stack<>();
        
        int l=expression.length();
       for(int i=0;i<l;i++){
            if(expression.charAt(i)=='('){
        stack.push('(');
    }

        else{
            if(expression.charAt(i)==')'){
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
               
            }
            else{
                return false;
            }
        }
        }
        // if(!stack.isEmpty()){
        //     return false;
        // }
        // return true;
        
        // Or
        return stack.isEmpty();
    
       }
  }
