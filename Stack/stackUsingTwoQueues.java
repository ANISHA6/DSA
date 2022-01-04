public class Stack {

    //Define the data members
    Queue<Integer> q;
    Queue<Integer> temp;
    


    public Stack() {
        //Implement the Constructor
        q=new LinkedList<Integer>();
        temp=new LinkedList<Integer>();
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() { 
        //Implement the getSize() function
        return q.size();
    }

    public boolean isEmpty() {
        //Implement the isEmpty() function
        return q.size()==0;
    }

    public void push(int element) {
        //Implement the push(element) function
        
        //TC:O(N)
//         if(q.size()==0){
//             q.add(element);
            
//         }else{
//         while(!q.isEmpty()){
//             temp.add(q.remove());
//         }
//         q.add(element);
//         while(!temp.isEmpty()){
//             q.add(temp.remove());
//         }
//     }
        
        //TC:O(1)
        q.add(element);
        
        
    }

    public int pop() {
        //Implement the pop() function
        
        //TC:O(1)
        // if(q.size()==0){
        //     return -1;
        // }
        // return q.remove();
        
        //TC:O(N)
         if(q.size()==0){
            return -1;
        }
        while(q.size()>1){
            temp.add(q.poll());
        }
        int ans=q.poll();
       Queue<Integer> t=q;
        q=temp;
        temp=t;
        return ans;
        
    }

    public int top() {
        //Implement the top() function
        //TC:O(1)
        // if(q.size()==0){
        //     return -1;
        // }
        // return q.peek();
        
        //TC:O(N)
         if(q.size()==0){
            return -1;
        }
        while(q.size()>1){
            temp.add(q.poll());
        }
        int ans=q.poll();
        temp.add(ans);
       Queue<Integer> t=q;
        q=temp;
        temp=t;
        return ans;
        
        
    }
}
