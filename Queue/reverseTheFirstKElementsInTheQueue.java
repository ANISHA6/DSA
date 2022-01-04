public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
		//Your code goes here
        
      
        
       if(k>input.size() ||input.isEmpty()){
            return input;
        }
        if(k<=0){
            return input;
        }
       
        Stack<Integer> stack=new Stack<>();
        //e.g k=3, elem=1 2 3 4 5
        for(int i=0;i<k;i++){
            stack.push(input.peek());//Pushing k elements in stack, i.e 1 2 3
            input.remove();
        }
        while(!stack.isEmpty()){
            input.add(stack.pop());//It will add k-elements in reverse order in queue,3 2 1
        }
        
        for(int i=0;i<input.size()-k;i++){//dequeue and enqueue n-k elements in queue,4 5 3 2 1
            input.add(input.peek());//op=3 2 1 4 5
            input.remove();
        }
        
        return input;
        
        
	}

