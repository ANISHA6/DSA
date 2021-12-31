// method 1
// using hashMap
// time o(n) && space o(n)



class Clone {
    //Function to clone a linked list with next and random pointer.
    Node copyList(Node head) {
        if(head == null)
            return null;
        
        HashMap<Node, Node> map = new HashMap<>();
        Node currNode = head;
        
        // creating another list and copying original list's data;
        while(currNode != null){
            map.put(currNode, new Node(currNode.data));
            currNode = currNode.next;
        }
        
        // copying and linking next and random pointer
        for(Map.Entry<Node, Node> entry: map.entrySet()){
            Node node = entry.getValue();
            
            node.next = map.get(entry.getKey().next);
            node.arb = map.get(entry.getKey().arb);
        }
        
        return map.get(head);
    }
}



// method 2
// two pointer approach
// time o(n) && space o(1)


class Solution {
    public Node copyRandomList(Node head) {
        Node iter = head;
        Node front = head;
        
        // connecting copy nodes just after to respective original nodes;
        while(iter != null){
            front = iter.next;
            Node copyNode = new Node(iter.val);
            iter.next = copyNode;
            copyNode.next = front;
            iter = front;
        }
        
        
        // delaing with random pointer
        iter = head;
        while(iter != null){
            if(iter.random != null)
                iter.next.random = iter.random.next;
            
            iter = iter.next.next;
        }
        
        
        // separating copy linked list and orignial linked list;
        iter = head;
        Node pseudoHead = new Node(0);
        Node copy = pseudoHead;
        while(iter != null){
            front = iter.next.next;
            copy.next = iter.next;
            
            iter.next = front;
            iter = iter.next;
            copy = copy.next;
        }
        
        
        return pseudoHead.next;
    }
}

//Approach 2

public class Solution {

    public static Node<Integer> clone(Node<Integer> head) {
        //Your code goes here
        if(head==null){
            return head;
        }
        Node<Integer> current=head;
        while(current!=null){
            Node<Integer> temp=current.next;
            Node<Integer> newNode=new Node<Integer>(current.data);
            current.next=newNode;
            newNode.next=temp;
            current=temp;
        }
        current=head;
        while(current!=null){
            if(current.next!=null){
                if(current.arb!=null){
                    current.next.arb=current.arb.next;
                }
                else
                    current.next.arb=current.arb;
            }
            if(current.next!=null){
                current=current.next.next;
            }
            else
                current=current.next;
        }
        Node<Integer> original=head;
        Node<Integer> copy=head.next;
        Node<Integer> newHead=copy;
        
        while(original!=null && copy!=null){
            if(original.next!=null){
                original.next=original.next.next;
                
            }
            if(copy.next!=null){
                copy.next=copy.next.next;
            }
            original=original.next;
            copy=copy.next;
            
        }
        
        return newHead;
            
        
    }
}
