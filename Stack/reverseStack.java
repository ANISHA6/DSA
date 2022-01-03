import java.util.*;
public class Solution {

	public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
		//Your code goes here
        
        if(input.isEmpty()){
           
            return;
        }
        
        
        int temp=input.pop();//Taking out the last elem to put it in last
      reverseStack(input, extra);//Calling the rescusion to reverse rest elemets of stack
        
        while(!input.isEmpty()){//Making input stack empty to put last elem in input as a first elem
        
        extra.push(input.pop());
        }
        
        input.push(temp);//Putting last elem in input 
        
        while(!extra.isEmpty()){
            input.push(extra.pop());
        }
        return;
        
    }
        

        
	
}
