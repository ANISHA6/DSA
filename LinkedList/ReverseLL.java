public class Solution {
  TC:O(N), SC:O(N)

	public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head) {
		//Your code goes here
        
        if(head==null || head.next==null){
            return head;
        }
        //Method 1
        LinkedListNode<Integer> temp=reverseLinkedListRec(head.next);
        head.next.next=head;
        head.next=null;
        return temp;
        
        
        //Method 2
        LinkedListNode<Integer> smallHead;
        smallHead=reverseLinkedListRec(head.next);
        LinkedListNode<Integer> tail=smallHead;
        while(tail.next!=null){
            tail=tail.next;
            
        }
        tail.next=head;
        head.next=null;
        
        return smallHead;
        
	}

}
// Reverse Iterative
//TC:O(N), SC:O(1)

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode p = head, q = null, r = null;
        while(p != null){
            r = q;
            q = p;
            p = p.next;
            q.next = r;
        }
        
        return q;
    }
}
