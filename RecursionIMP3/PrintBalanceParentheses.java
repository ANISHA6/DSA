import java.util.*;
public class Solution {
    public static void balanceParantheses(int open, int close, String op,ArrayList<String> list){
        if(open==0 &&close==0){
            list.add(op);
            return;
        }
        if(open==close){
            balanceParantheses(open-1, close,op+'{', list); // If already balance then add only open
        }
        else if(open==0){
            balanceParantheses(open, close-1, op+'}', list);
        }
        else if(open<close){
            balanceParantheses(open-1, close, op+'{', list);
             balanceParantheses(open, close-1, op+'}', list);
            
        }
        return;
    }
	public static void printParentheses(int n) {
		// Write your code here
       ArrayList<String> list=new ArrayList<>();
        balanceParantheses(n,n,"",list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
	}
}
