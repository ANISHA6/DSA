public class Solution {

	public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
		//Your code goes here
        
        if(head==null){
            return head;
        }
     LinkedListNode<Integer> curr=head;
        while(curr!=null){
            LinkedListNode<Integer> temp=curr;
            while(temp!=null && temp.data.equals(curr.data)){
                temp=temp.next;
                
            }
            
            curr.next=temp;
            curr=curr.next;
}
        return head;
        
        
	}

}
