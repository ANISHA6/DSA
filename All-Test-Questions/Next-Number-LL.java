/*************** 
 * Following is the Node class already written 
class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}
}
 ***************/

public class Solution {
  
public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head){
    //method 2
    LinkedListNode<Integer> curr=head;
        LinkedListNode<Integer> pre=null;
    while(curr!=null){
        LinkedListNode<Integer> temp=curr.next;
        curr.next=pre;
        pre=curr;
        curr=temp;
    }
    return pre;
    
    //method 1, not working for some test cases
    if(head==null || head.next==null){
        return head;
    }
    
   LinkedListNode<Integer>ans= reverse(head.next);
    LinkedListNode<Integer> tail=head.next;
    
    tail.next=head;
    head.next=null;
    return ans;
    
    
}
	public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) {
         if(head==null){
             return head;
         }
        head=reverse(head);
        LinkedListNode<Integer> rhead=head,pre=null;
        int c=1;
        int num;
        
        while(rhead!=null){
            num=(c+rhead.data)%10;
            c=(c+rhead.data)/10;
            rhead.data=num;
            pre=rhead;
            rhead=rhead.next;
            
        }
        if(c>0){
            LinkedListNode<Integer> tail=new LinkedListNode<Integer>(c);
            pre.next=tail;
        }
        return reverse(head);
        
	}


}
