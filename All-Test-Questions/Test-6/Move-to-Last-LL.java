/***********
 
Following is the Linked list node structure already written 
 
class Node<T> {
    public T data;
    public Node<T> next;
    public Node(T data) {
		 this.data=data;
	 }
}

************/


public class Solution {


	public static Node<Integer> func(Node<Integer> head,int n) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        if(head==null){
            return head;
        }
        Node<Integer> temp=head, last=null, pre=null;
        int l=1;
        while(temp.next!=null){
            l++;
            temp=temp.next;
            
        }
        last=temp;
        temp=head;
        for(int i=0;i<l;i++){
            if(temp.data.equals(n)){
                if(pre==null){
                    Node temp1=new Node(n);
                    head=head.next;
                    last.next=temp1;
                    last=last.next;
                    pre=null;
                    temp=head;
                }else{
                    Node temp2=new Node(n);
                    pre.next=temp.next;
                   
                    last.next=temp2;
                    last=last.next;
                    temp=temp.next;
                }
                
            }else{
                pre=temp;
                temp=temp.next;
            }
            
                
        }
        return head;
  }
}
