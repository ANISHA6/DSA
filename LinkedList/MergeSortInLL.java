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
    
    public static LinkedListNode<Integer> mid(LinkedListNode<Integer> head){
        LinkedListNode<Integer> slow=head, fast=head;
        if(fast==null){
            return slow;
        }
        
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static LinkedListNode<Integer> merge(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2){
        
        if(head1==null){
            return head2;
        }
        if(head2==null){
             return head1;
        }
        
        LinkedListNode<Integer> t1=head1, t2=head2;
        LinkedListNode<Integer> head=null, tail=null;
        
        if(t1.data<=t2.data){
            tail=t1;
            head=t1;
            t1=t1.next;
        }
        else{
            tail=t2;
            head=t2;
            t2=t2.next;
        }
        
        while(t1!=null && t2!=null){
            if(t1.data<=t2.data){
                tail.next=t1;
                tail=t1;
                t1=t1.next;
            }
            else{
                tail.next=t2;
                tail=t2;
                t2=t2.next;
            }
        }
        if(t1!=null){
            tail.next=t1;
        }
        else{
            tail.next=t2;
        }
        return head;
    }

	public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
		//Your code goes here
        if(head==null || head.next==null){
            return head;
        }
        LinkedListNode<Integer> part1h=head;
        LinkedListNode<Integer> part2=mid(head);
        LinkedListNode<Integer> part2h=part2.next;
        part2.next=null;
        LinkedListNode<Integer> head1=mergeSort(part1h);
        LinkedListNode<Integer> head2=mergeSort(part2h);
        LinkedListNode<Integer>  ans=merge(head1,head2);
        return ans;
	}

}
