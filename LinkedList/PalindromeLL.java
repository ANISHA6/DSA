public class Solution {
// Method 1
	public static boolean isPalindrome(LinkedListNode<Integer> head) {
        
		//Your code goes here
        if(head==null){
            return true;
        }
        
      
        LinkedListNode<Integer> slow=head;
         LinkedListNode<Integer> fast=head;
          LinkedListNode<Integer> pre=null;
        
        while(fast!=null && fast.next!=null){
            
            fast=fast.next.next;
            LinkedListNode<Integer> temp=slow;
            slow=slow.next;
            
            temp.next=pre;
            pre=temp;
            
        }
        if(fast!=null){
            slow=slow.next;// to avoid middle no. in case of odd no. of number.
        }
        while(pre!=null && slow!=null){
            if(pre.data!=slow.data){
                return false;
            }
            pre=pre.next;
            slow=slow.next;
        }
  }
}
    
    /// Method 2
    
    class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode temp = midPoint(head);
        
        ListNode head2 = temp.next;
        temp.next = null;
        
        head2 = reverse(head2);
        
        while(head != null && head2 != null){
            if(head.val != head2.val)
                return false;
            
            head = head.next;
            head2 = head2.next;
        }
        
        return true;
    }
    
    private ListNode midPoint(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    private ListNode reverse(ListNode head){
        ListNode p = head, q = null, r = null;
        while(p!= null){
            r = q;
            q = p;
            p = p.next;
            q.next = r;
        }
        
        return q;
    }
    
}
    
