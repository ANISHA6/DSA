/*

 	Following is the Node class already written for the Linked List

	class LinkedListNode<T> {
		T data;
		LinkedListNode<T> next;

		public Node(T data) {
			this.data = data;
		}
	}

*/

public class Solution {

	public static void printIthNode(LinkedListNode<Integer> head, int i){
		//Your code goes here
        LinkedListNode<Integer> temp=head;
        if(temp==null){
            return;
        }
        //Method 1
        int c=-1;
        while(temp!=null){
            c++;
            if(c==i){
                System.out.println(temp.data);
                return;
            }
            temp=temp.next;
            
        }
        // Method 2
        int position=0;
        while(temp!=null && position<i){
            position++;
            temp=temp.next;
        }
        if(temp!=null){
            System.out.println(temp.data);
        }
        
        
       }
}
