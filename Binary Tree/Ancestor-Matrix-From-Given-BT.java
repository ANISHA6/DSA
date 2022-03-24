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
  
    public static void fill(BinaryTreeNode<Integer> root, int[][] matrix,int n){
        if(root==null){
            return ;
        }
        fill(root.left, matrix, n);//Ask recursion to find the ancestor of left and right node
        fill(root.right, matrix,n);
        //then we just have to work for root node
        
        if(root.left!=null){
            matrix[root.data][root.left.data]=1;//because root is ancestor of its left
            for(int i=0;i<n;i++){
                if(matrix[root.left.data][i]==1)//if left is ancestor of any node 
                    matrix[root.data][i]=1;//then, left's root is also ancestor of those nodes
            }
        }
        if(root.right!=null){
            matrix[root.data][root.right.data]=1;
            for(int i=0;i<n;i++){
                if(matrix[root.right.data][i]==1)
                    matrix[root.data][i]=1;
            }
        }
        
    }
    
        public static void ancestor(BinaryTreeNode<Integer> root, int[][] matrix) {
            //Write your code here
            
            if(root==null){
                return;
            }
            int n=matrix.length;
            fill(root, matrix,n);
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(matrix[i][j]+" ");
                }
                System.out.println();
            }
        }
        
    }
    
