public class Solution {

	public static LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int i, int j) {
		//Your code goes here
        if(head==null || i==j){
            return head;
        }
       LinkedListNode<Integer> prei=null;
           LinkedListNode<Integer> curri=head;
        int x=0;
        while(curri!=null && x<i){
            prei=curri;
            x++;
            curri=curri.next;
        }
        LinkedListNode<Integer> prej=null;
            LinkedListNode<Integer> currj=head;
        int y=0;
        
        while(currj!=null && y<j){
            prej=currj;
            y++;
            currj=currj.next;
        }
        
        
       if(prei!=null){
            prei.next=currj;
        }
        else{
            head=currj;
        }
        if(prej!=null){
            prej.next=curri;
        }
        else
            head=curri;
            
        
     
            
         LinkedListNode<Integer> temp=curri.next;
        curri.next=currj.next;
        currj.next=temp;
        
        
    
        return head;
	}

}
