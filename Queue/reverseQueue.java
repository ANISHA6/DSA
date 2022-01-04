public class Solution {

	public static void reverseQueue(Queue<Integer> input) {
		//Your code goes here
        
        if(input.isEmpty()){
            return;
        }
        
        int data=input.peek();
        input.poll();
        reverseQueue(input);
        input.add(data);
        return;
            
	}

}
