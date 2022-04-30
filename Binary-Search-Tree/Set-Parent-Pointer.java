import java.util.*;

/*
class Node {
	int data;
	Node left;
	Node right;
	Node parent;

	Node(int data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
*/

public class Solution {
    private static void setParent(Node node, Node parent){
        if(node==null)
            return;
        node.parent=parent;
        setParent(node.left, node);
        setParent(node.right, node);
    }

	public static Node solve(int[] arr){
        Node root=null;
            Node[] nodes=new Node[arr.length];
        int size=0;
        for(int i=0;i<nodes.length;i++){
            if(arr[i]!=-1){
                nodes[i]=new Node(arr[i], null, null);
                size++;
                if(i>0){
                    int pi=(i-1)/2;
                if(i==2*pi+1){
                    nodes[pi].left=nodes[i];
                }else{
                    nodes[pi].right=nodes[i];
                }
            }
                
                    
            }
        }
        
        root=nodes[0];
        setParent(root, null);
        return root;

	}
	
}
