/*
Structure of the Node used for implementing the Doubly Linked List

public class DoublyLinkedListNode<T> {
    T data;
    DoublyLinkedListNode<T> next;
    DoublyLinkedListNode<T> prev;
    
    DoublyLinkedListNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

*/


public class Solution {
    public static DoublyLinkedListNode<Integer> merge(DoublyLinkedListNode<Integer> head1, DoublyLinkedListNode<Integer> head2){
        
        if(head1==null){
            return head2;
        }
        if(head2==null){
            return head1;
        }
        if(head1.data<head2.data){
            head1.next=merge(head1.next, head2);//Calling recursion to merge head1.next and head2
            head1.next.prev=head1;//Connecting next of head1 to head1
            head1.prev=null;
            return head1;
        }else{
             head2.next=merge(head1, head2.next);
            head2.next.prev=head2;
            head2.prev=null;
            return head2;
        }
    }
    public static DoublyLinkedListNode<Integer> reverse(DoublyLinkedListNode<Integer> head){
        
        DoublyLinkedListNode<Integer> temp=null;
        DoublyLinkedListNode<Integer> curr=head;
        
        while(curr!=null){
            temp=curr.prev;
            curr.prev=curr.next;
            curr.next=temp;
            curr=curr.prev;
        }
        if(temp!=null){
            head=temp.prev;
        }
        return head;
        
    }

    public static DoublyLinkedListNode<Integer> sorting(DoublyLinkedListNode<Integer> head) {
        //Your Code Goes Here
        
        if(head==null || head.next==null){
            return head;
        }
    
        DoublyLinkedListNode<Integer> temp=head.next;
        
        
        while(temp!=null){
            if(temp.data<temp.prev.data){//Comparing current and previous data
                break;
            }
            temp=temp.next;
    }
        

         if(temp==null){//i.e list only has strictly increasing no.
            return head;
        }
        
        temp.prev.next=null;//Disconnecting the node,that is connected to temp 
        
        temp.prev=null;//Disconnecting the node that is previous of temp, from temp
        
        if(temp==head){//i.e list only has strictly decreasing no.
            return reverse(temp);
        }
        
        DoublyLinkedListNode<Integer> p2=reverse(temp);//Reverse the strictly decreasing list, to 
        //get strictly increasing list, because we can only merge two strictly increasing lists
       DoublyLinkedListNode<Integer> ans= merge(head,p2);// Merging two strictly increasing lists
        return ans;
    }

}
