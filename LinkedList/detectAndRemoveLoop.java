/*  This is the class used for the structure of the Linked List.

class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;
	
	public LinkedListNode(T data) {
		this.data = data;
		this.next = null;
	}
}
	
*/

public class Solution {

    public static LinkedListNode<Integer> find(LinkedListNode<Integer> head) {
		int flag=0;
		LinkedListNode<Integer>slow=head,fast=head;
		while(fast!=null&&fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)// Detecting the loop
			{  flag=1;
				break;
			}
		}
		if(flag==0)
		return null;
		 fast=head;
		 while(fast!=slow)
		 {
			 fast=fast.next;
			 slow=slow.next;
		 }
		 return fast;
	}

	public static void detect(LinkedListNode<Integer> head) {
		//Your Code Goes Here. No need to print the list, it has already been taken care.
        if(head==null){
            return;
        }
        
        LinkedListNode<Integer> loop=find(head);//Function for finding the loop
        
        LinkedListNode<Integer> temp=loop;
        
        while(temp.next!=loop){// Moving the temp till last node
            temp=temp.next;
        }
        temp.next=null;// Removing the loop
	}
}
