
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
