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
    
    public static LinkedListNode<Integer> mergeTwoSortedLinkedLists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        //Your code goes here
        
       if(head1==null){
           return head2;
       }
        if(head2==null){
            return head1;
        }
         
        LinkedListNode<Integer> head=null, tail=null, t1=head1;
        LinkedListNode<Integer>  t2=head2;
        
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

}
