public class Solution {
    
    //Here every column is sorted LL
    //So just merge two sorted LL recursively
  //Connected with right and down pointer
//     5 6 10 11
//     8 7 30 12
//     9   50 13
//     20     14
  //o/p-5 6 7 8 9 10 11 12 13 14 20 30 50 Null
    public static LinkedListNode<Integer> combine(LinkedListNode<Integer> temp1, LinkedListNode<Integer> temp2){
        
        if(temp1==null){
            return temp2;
        }
        if(temp2==null){
            return temp1;
        }
        
        LinkedListNode<Integer> head=null;
        if(temp1.data<temp2.data){
            head=temp1;
            head.down=combine(temp1.down,temp2);
        }
        else{
            head=temp2;
            head.down=combine(temp1,temp2.down);
        }
        return head;
    }

	public static LinkedListNode<Integer> flat(LinkedListNode<Integer> head) {
		//Your code goes here
        
        if(head==null || head.right==null){
            return head;
        }
        
        return combine(head, flat(head.right));
	}

}
// Method 2
// TC:O(N), SC:O(1)
class GfG
{
    Node flatten(Node root)
    {
	    // base case - when root is null or when we are standing on the last pointer
	    if(root == null || root.next == null)
	        return root;
	    
	    // traversing in order to move to last pointer i.e. moving right
	    root.next = flatten(root.next);
	    
	    // merging
	    root = mergeTwoLL(root, root.next);
	    
	    
	    return root;
    }
    
    private Node mergeTwoLL(Node a, Node b){
        Node temp = new Node(0);
        Node res = temp;
        
        while(a != null && b != null){
            if(a.data < b.data){
                temp.bottom = a;
                temp = a;
                a = a.bottom;
            } else{
                temp.bottom = b;
                temp = b;
                b = b.bottom;
            }
        }
        
        if(a != null)
            temp.bottom = a;
        
        if(b != null)
            temp.bottom = b;
            
        return res.bottom;
    }
}
