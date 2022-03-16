/*Linked List Node Class

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;
    
    public LinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }
}

*/

public class Solution {
    //step 1, reverse the LL
    public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head){
        if(head==null || head.next==null)
            return head;
        LinkedListNode<Integer> curr=head, pre=null;
        while(curr!=null){
            LinkedListNode<Integer> f=curr.next;
            curr.next=pre;
            pre=curr;
            curr=f;
            
        }
        return pre;
    }
    //step 2
    //multiplying 1st LL with each digit of 2nd LL
    public static LinkedListNode<Integer> multiplyLLWithDigit(LinkedListNode<Integer> head, int digit){
        //ac, ans current
        //create dummy node for ans
        LinkedListNode<Integer> dummy=new LinkedListNode<Integer>(-1);
        LinkedListNode<Integer> ac=dummy;
        int carry=0;
        while(head!=null || carry!=0){
            int sum=carry+(head!=null?head.data:0)*digit;
            int dig=sum%10;
            carry=sum/10;
            
            ac.next=new LinkedListNode<Integer>(dig);
            if(head!=null)
                head=head.next;
            ac=ac.next;
        }
        return dummy.next;
        
    }
    // step 3, add LL
    public static void addTwoLL(LinkedListNode<Integer> head, LinkedListNode<Integer> ansItr){
        LinkedListNode<Integer>c1=head;
        LinkedListNode<Integer>c2=ansItr;
        
        int carry=0;
        while(c1!=null || carry!=0){
            int sum=carry+(c1!=null?c1.data:0)+(c2.next!=null?c2.next.data:0);
            
            int digit=sum%10;
            carry=sum/10;
            if(c2.next!=null){
                c2.next.data=digit;
        }else{
            c2.next=new LinkedListNode<Integer>(digit);
        }
        if(c1!=null)c1=c1.next;
        c2=c2.next;
    }
}

    public static void multiply(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        //Your code goes here
        if(head1==null  && head2==null)
            return;
        
            head1=reverse(head1);
            head2=reverse(head2);
            
       
            LinkedListNode<Integer> head2_itr=head2;
            LinkedListNode<Integer> dummy=new LinkedListNode<Integer>(-1);
            LinkedListNode<Integer> ansItr=dummy;
            while(head2_itr!=null){
                LinkedListNode<Integer> prod=multiplyLLWithDigit(head1, head2_itr.data);
                head2_itr=head2_itr.next;//
                
                addTwoLL(prod, ansItr);
                ansItr=ansItr.next;//to leave 1st digit for addition after multiplication
            }
            LinkedListNode<Integer> head= reverse(dummy.next);
            
           while(head!=null){
              System.out.print(head.data+" ");
              head=head.next;
        }
        
    }

}
