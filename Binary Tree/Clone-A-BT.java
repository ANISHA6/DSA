public class Solution {

    /*	Binary Tree Node class
     * 
     * class BinaryTreeNode<T> {
            T data;
            BinaryTreeNode<T> left;
            BinaryTreeNode<T> right;
            BinaryTreeNode<T> random;
            public BinaryTreeNode(T data) {
                this.data = data;
            }
        }
        */
    
    
    public static  BinaryTreeNode<Integer> LeftorRight( BinaryTreeNode<Integer> root){
             if(root==null){
               return null;
            }
         BinaryTreeNode<Integer> leftnode=root.left;
        root.left=new BinaryTreeNode<Integer>(root.data);
        root.left.left=leftnode;
        if(leftnode!=null){
            leftnode.left=LeftorRight(leftnode);
            
        }
        root.left.right=LeftorRight(root.right);
        return root.left;
        
        
    }
    public static void RandomNode( BinaryTreeNode<Integer> root,  BinaryTreeNode<Integer> clonedroot ){
        if(root==null){
            return;
        }
        if(root.random!=null){
            clonedroot.random=root.random.left;
        }else{
            clonedroot.random=null;
        }
        if(root.left!=null && clonedroot.left!=null){
            RandomNode(root.left.left, clonedroot.left.left);
        }
        RandomNode(root.right, clonedroot.right);
    }
    public static void tree(BinaryTreeNode<Integer> root,  BinaryTreeNode<Integer> clonedroot){
        if(root==null){
            return;
        }
        
        if(clonedroot.left!=null){
             BinaryTreeNode<Integer> leftnode=clonedroot.left.left;// it will become left child of cloned root
            root.left=root.left.left;
            clonedroot.left=leftnode;
        }else{
            root.left=null;
        }
        tree(root.left, clonedroot.left);
        tree(root.right, clonedroot.right);
    }
    
    
        public static BinaryTreeNode<Integer> clonedTree(BinaryTreeNode<Integer> root) {
            //Write your code here
            
            if(root==null){
                return null;
            }
             BinaryTreeNode<Integer> clonedroot=LeftorRight(root);//It will return cloned root
            //After getting cloned root, will connect all the random node with cloned tree, same as original tree
            RandomNode(root, clonedroot);
            // separating original tree's root and cloned tree's root or (clonedroot)
            tree(root, clonedroot);
            //after separating, returning cloned tree's root
            return clonedroot;
            
        }
        
    }
    
