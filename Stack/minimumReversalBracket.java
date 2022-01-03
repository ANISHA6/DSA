import java.util.*;
public class Solution {

	public static int countBracketReversals(String input) {
		//Your code goes here
        if(input.length()%2!=0){
            return -1;
        }
        
        Stack<Character> stack=new Stack<>();
        int count=0;
        
        for(int i=0;i<input.length();i++){
            char c=input.charAt(i);
            if(c=='{'){
                stack.push(c);
            }
            else{
                if(!stack.isEmpty() && stack.peek()=='{'){
                    stack.pop();
                }else
                    stack.push(c);
                
            }
        }
        
        while(!stack.isEmpty()){
            char c1=stack.pop();
            char c2=stack.pop();
            
            if(c1==c2){
                count+=1;
            }
            else{
                count+=2;
            }
        }
        return count;
	}

}
