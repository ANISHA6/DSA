
public class Solution {

	public static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {
		//Your code goes here
        if(head==null || head.next==null){
            return head;
        }
        
        LinkedListNode<Integer> oddh=null,oddt=null;
            LinkedListNode<Integer> evenh=null, event=null;
        
        while(head!=null){
            if(head.data%2==0){
                if(event==null){
                    evenh=head;
                    event=head;
                }else{
                event.next=head;
                event=head;}
            }
            else{
                if(oddt==null){
                    oddt=head;
                    oddh=head;
                }else{
                oddt.next=head;
                oddt=head;}
            }
            head=head.next;
        }
       if(oddt!=null){
           oddt.next=null;
       }
        if(event!=null){
            event.next=null;
        }
        if(oddt==null && oddh==null){
            return evenh;
        }
        else{
            oddt.next=evenh;
        }
       // evenh=null;
        return oddh;
        
        }
}
