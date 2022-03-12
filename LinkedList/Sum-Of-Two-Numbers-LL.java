public class Solution {
    public static LinkedListNode<Integer> ans=null;
       
    //adding the new node at first in list
    public static void addFirst(int c){
        LinkedListNode<Integer> res=new LinkedListNode<Integer>(c);
        if(ans==null){
            ans=res;
        }else{
        
            
            res.next=ans;
            ans=res;
        }
    }
    
    private static int size(LinkedListNode<Integer> head){
        int size=0;
        while(head!=null){
            head=head.next;
            size++;
        }
        return size;
    }
    
    public static int addHelper(LinkedListNode<Integer> one, int pv1,LinkedListNode<Integer> two, int pv2, LinkedListNode<Integer> ans){
        
        if(one==null && two== null){
            return 0;//if both head is null, return carry zero
        }
        int data=0;
        //add with equal point value of two number
        if(pv1>pv2){
            int oc=addHelper(one.next,pv1-1,two, pv2, ans);
            data=one.data+oc;
            
        }else if(pv1<pv2){
            int oc=addHelper(one,pv1,two.next, pv2-1, ans);
            data=two.data+oc;
            
        }else{
            int oc=addHelper(one.next,pv1-1,two.next, pv2-1, ans);
            data=one.data+two.data+oc;
        }
        int nd=data%10;
        int nc=data/10;
       // ans.addFirst(nd);
        addFirst(nd);
        return nc;
    }
//    
	public static LinkedListNode<Integer> addNumbers(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {  
		//Your code goes here
        
     
        int c=addHelper(head1,size(head1), head2, size(head2), ans);
        if(c>0){
            addFirst(c);
        }
        return ans;
  }
}
