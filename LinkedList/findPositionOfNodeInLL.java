/****************************************************************

	Following is the class structure of the Node class:

	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;
    
    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

*****************************************************************/

public class Solution {
	public static int findNode(LinkedListNode<Integer> head, int n) {
		// Write your code here.
        
        if(head==null){
            return -1;
        }
        
        //method 1
        
        int pos=0;
        while(head!=null){
            if(head.data.equals(n)){
                return pos;
            }
            pos++;
            head=head.next;
        }
        return -1;
        //method 2
        LinkedListNode<Integer> pre=head;
        int c=0;
        while(c<n-1 && pre!=null){
            c++;
            pre=pre.next;
        }
        if(pre.data==n){
            return c++;
        }
        return -1;
        
        
	}
}
