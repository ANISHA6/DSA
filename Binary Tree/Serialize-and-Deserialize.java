import java.util.*;

public class Solution {

    /*	Binary Tree Node class
     * 
     * class BinaryTreeNode<T> {
            T data;
            BinaryTreeNode<T> left;
            BinaryTreeNode<T> right;

            public BinaryTreeNode(T data) {
                this.data = data;
            }
        }
        */
    private static int i;
    public static void serialize(BinaryTreeNode<Integer> root, ArrayList<Integer> tree) {
        //Write your code here
        
        if(root!=null){
            tree.add(root.data);//Serilizing in preorder manner
            serialize(root.left,tree);//so that , we can deserialize it very easily
            serialize(root.right,tree);
        }else{
            tree.add(-1);
        }
        return;
    }



    public static BinaryTreeNode<Integer> helper(ArrayList<Integer> tree) {
        //Write your code here
        if(i>=tree.size() || tree.get(i)==-1){
            i++;
            return null;
        }
        
        BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(tree.get(i));
        i++;
        root.left=helper(tree);
        root.right=helper(tree);
        return root;
    }    

    public static BinaryTreeNode<Integer> deSerialize(ArrayList<Integer> tree) {
        //Write your code here
        //Deserializing means, constructing tree again after serializing
        return helper(tree);

    }


}
