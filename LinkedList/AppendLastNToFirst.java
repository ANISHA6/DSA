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

	public static LinkedListNode<Integer> appendLastNToFirst(LinkedListNode<Integer> head, int n) {
		//Your code goes here
        
        if(head==null || n==0){
            return head;
        }
        //Method 1
        LinkedListNode<Integer> fast=head;
        LinkedListNode<Integer> slow=head;
        LinkedListNode<Integer> initialhead=head;
        
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        
        LinkedListNode<Integer> temp=slow.next;
        slow.next=null;
        fast.next=initialhead;
        head=temp;
        return head;
        
        //Method 2
        int t=0;
        LinkedListNode<Integer> temp=head;
        while(temp!=null){
            t++;
            temp=temp.next;
        }
        if(t==n){
            return head;
        }
        int cut=t-n;// t is total no. of nodes
        LinkedListNode<Integer> tail=head;
        LinkedListNode<Integer> newhead=null;
        int c=0;
        
        while(c<cut-1 && tail!=null && n<t){
            c++;
            tail=tail.next;
            
        }
        
        newhead=tail.next;
        tail.next=null;
        LinkedListNode<Integer> ans=newhead;
        
        while(newhead.next!=null){
            newhead=newhead.next;
        }
        
        newhead.next=head;
        
        return ans;
	}

}
