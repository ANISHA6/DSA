/*

 	Following is the Node class already written for the Linked List

	class LinkedListNode<T> {
		T data;
		LinkedListNode<T> next;

		public Node(T data) {
			this.data = data;
		}
	}

*/


public class Solution {

	public static int length(LinkedListNode<Integer> head){
		//Your code goes here
        
     //  LinkedListNode<Integer> temp=head;
        
        if(head==null){
            return 0;
        }
        int count=0;
    
        while(head!=null){
            count++;
            head=head.next;
        }
   
        return count;
	}
}
