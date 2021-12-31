public class Solution {
	
	public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N) {
		//Your code goes here
        
        
        if(head==null || M==0){
            return null;
        }
        if(N==0){
            return head;
        }
        //Method 1, not working for some test cases
          LinkedListNode<Integer> currentNode=head;
          LinkedListNode<Integer> temp=null;
        
        while(currentNode!=null){
            int take=0;
            int skip=0;
            while(currentNode!=null && take<M){
                if(temp==null){
                    temp=currentNode;
                }else{
                    temp.next=currentNode;
                    temp=currentNode;
                }
                currentNode=currentNode.next;
                take+=1;
            }
            while(currentNode!=null && skip<N){
                currentNode=currentNode.next;
                skip+=1;
            }
        }
        if(temp!=null){
            temp=temp.next;
        }
        return head;
        
         
        
//         //Method 2
          LinkedListNode<Integer> t1=head;
              LinkedListNode<Integer> t2=head;
        int c1=1;
         int c2=1;
        
       while(t1!=null && t2!=null){
             if(c1!=M){
               c1++;
               c2++;
                   t1=t1.next;
                t2=t2.next;
                
             }else{
                 if(c2!=M+N){
                   
                     c2++;
                     t2=t2.next;}
                
                 else{
                     t2=t2.next;
                     t1.next=t2;
                     t1=t1.next;
                     c1=1;
                     c2=1;
                
                 }
         }
       }
        
             if(t1!=null){
            t1.next=t2;
             }
            
            
                 return head;
 	}
}
