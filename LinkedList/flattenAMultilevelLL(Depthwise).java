public class Solution {
    public static LinkedListNode<Integer> flattenList(LinkedListNode<Integer> node) { 
        //Your code goes here
        if(node==null){
            return node;
        }
        
        LinkedListNode<Integer> temp=node.next;
        node.next=flattenList(node.down);
        
        LinkedListNode<Integer> tail=node;
        while(tail.next!=null){
            tail=tail.next;
        }
        tail.next=flattenList(temp);
        return node;
        
        
    } 
}
