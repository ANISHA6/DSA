
public class Solution {


	public static int findNodeRec(LinkedListNode<Integer> head, int n) {
    	//Your code goes here
        
        if(head==null){
            return -1;
        }
        
        
        if(head.data.equals(n)){
           return 0;
        }
      
       int index=findNodeRec(head.next,n);
        if(index==-1){
            return -1;
        }
        return index+1;
  }
}
