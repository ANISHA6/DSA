public class Solution {
    // Recursive ,error=StackOverFlow
    //TC:O(N), SC:O(N)
    public static LinkedListNode<Integer> mid(LinkedListNode<Integer> slow, LinkedListNode<Integer> fast){
        if(fast==null){
            return slow;
        }
        
         if(fast.next==null ||fast.next.next==null){
            return slow;
        }
        
        
        LinkedListNode<Integer> ans=mid(slow.next, fast.next.next);
        return ans;
    }
    
    public static LinkedListNode<Integer> midPoint(LinkedListNode<Integer> head) {
        //Your code goes here
           return mid(head,head);
        
        
        //Iterative
        //TC:O(N), SC:O(1)
        if(head==null){
            return head;
        }
        LinkedListNode<Integer> slow=head;
            LinkedListNode<Integer> fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
        
    }

}
