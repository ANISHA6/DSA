/*

	Following is the Node class already written for the Linked List

	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;
    
    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

*/

public class Solution {

	public static LinkedListNode<Integer> insert(LinkedListNode<Integer> head, int pos, int data){
		//Your code goes here
        
LinkedListNode<Integer> currNode=new LinkedListNode<Integer>(data);
        if(pos==0){
            currNode.next=head;
            return currNode;
        }
        
        LinkedListNode<Integer> pre=head;
        
        int c=0;
        while(c<pos-1 && pre!=null){
            c++;
            pre=pre.next;
        }
        if(pre!=null){
            currNode.next=pre.next;
            pre.next=currNode;
        }
        return head;
     }
}
