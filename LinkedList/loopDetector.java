
public class solution {
// Here we are using floid cycle detector algorthum
	public static ListNode<Integer> FindCycleNode(ListNode<Integer> head) {
		int flag=0;
		ListNode<Integer>slow=head,fast=head;
		while(fast!=null&&fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)//Checking whether loop is exist or not
			{  flag=1;
				break;
			}
		}
		if(flag==0)
		return null;
        //Slow can only visit the cycle nodes,so if fast and slow meet ,i.e this is the first node of loop
		 fast=head;
		 while(fast!=slow)//If both pointer meet, that is found first node of loop
		 {
			 fast=fast.next;
			 slow=slow.next;
		 }
		 return fast;
	}
	
	//If loop exist then return true otherwise false
	
	// method 1
// used hashing
// time o(n) && space o(n)

public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> hs = new HashSet<>();
        
        while(head!= null){
            if(hs.contains(null))
                break;
            else if(hs.contains(head))
                return true;
            else
                hs.add(head);
            
            head = head.next;
        }
        
        return false;
    }
}
	
	
// method 2
// using two pointers
// time o(n) && space o(1)


public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast)
                return true;
        }
        
        return false;
    }
}
