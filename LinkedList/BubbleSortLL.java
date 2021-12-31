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
// Points for bubble sort
// Compare the data like bubble
//In every one pass largest element will come to the end
//So next time we have to reduce the loop size by i i.e, n-i
public class Solution {
    public static void swap(LinkedListNode<Integer> head1,LinkedListNode<Integer> head2){
       int x=head1.data;
        head1.data=head2.data;
        head2.data=x;
       
    }

	public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head) {
		//Your code goes here
        
        if(head==null){
            return head;
        }
        int s=0;
        LinkedListNode<Integer> temp1=head;
        while(temp1!=null){//Finding length of LL
            s++;
            temp1=temp1.next;
        }
        
      // Method 1
        
       // if(s>1){
        for(int i=0;i<s;i++){
            LinkedListNode<Integer> temp=head;
            LinkedListNode<Integer> next=head.next;
              
             for(int j=0;j<s-i;j++){
                if(temp!=null && next!=null){
                if(temp.data>next.data){
                    swap(temp,next);// Swapping data not node
                }
                temp=next;
                next=next.next;
            }
             }
        }
       
       }
        return head;
        
        
        //Method 2
        
        for(int i=0;i<s-1;i++){
            LinkedListNode<Integer> pre=null;
            LinkedListNode<Integer> curr=head;
            for(int j=0;j<(s-i-1);j++){
                if(curr.data<=curr.next.data){
                    pre=curr;
                    curr=curr.next;
                }else{
                    if(pre==null){
                        LinkedListNode<Integer> fwd=curr.next;
                        head=head.next;
                        curr.next=fwd.next;
                        fwd.next=curr;
                        pre=fwd;
            
                    }else{
                        LinkedListNode<Integer> fwd=curr.next;
                        pre.next=fwd;
                        curr.next=fwd.next;
                        fwd.next=curr;
                        pre=fwd;
                    }
                }
            }
        }
        return head;
        
   	}
}
