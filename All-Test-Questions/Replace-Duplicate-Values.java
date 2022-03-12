/******** 
Following is the structure of Linked list node
class LinkedListNode<T> {
	public T data;
	public LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
		this.next = null;
	}
}
*********/
import java.util.*;
public class solution {

	public static void changeLL(LinkedListNode<Integer> head) {
		// Write your code here
     Map<Integer, Integer> map=new HashMap<>();
        LinkedListNode<Integer> temp=head;
        int max=0;
        while(temp!=null){
            // map.put(temp.data,(map.get(temp.data)==null?0:map.get(temp.data))+1);
            map.put(temp.data, map.getOrDefault(temp.data, 0)+1);
            if(max<temp.data)
                max=temp.data;
            temp=temp.next;
        }
        while(head!=null){
            if(map.get(head.data)>1)
                map.put(head.data, -1);
            else if(map.get(head.data)==-1)
                head.data=++max;
            head=head.next;
        }
	}
}
