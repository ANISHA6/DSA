/****************************************************************

	Following is the Node class already written for the Linked List

	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;
    
    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

*****************************************************************/

public class Solution {
	public static LinkedListNode<Integer> deleteNode(LinkedListNode<Integer> head, int pos) {
		// Write your code here.
        if(head==null){
            return head;
        }
        
        if(pos==0){
            head=head.next;
            return head;
        }
        
        LinkedListNode<Integer> pre=head;
       // LinkedListNode<Integer> ans=head;
        
         int c=-1;
       
         
        while(pre.next!=null){
            c++;
            if(c==pos-1){
               pre.next=pre.next.next;
                break;
            }
            else{
            pre=pre.next;
          
        }}
        
       
        
        return head;
	}
}
//Delete the given node
//TC:O(1), SC:O(1)

class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
