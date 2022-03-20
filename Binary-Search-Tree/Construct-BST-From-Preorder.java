public class Solution {
    public static BinaryTreeNode<Integer> helper(int[] preorder, int s, int e){
        if(s>e){
            return null;
        }
        
        BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(preorder[s]);
        if(s==e)
            return root;
        
        int ls=s+1;//left start
        int le=-1;//left end
        int rs=Integer.MAX_VALUE;//right start
         int re=e;//right end
        
       for(int i=s+1;i<=e;i++){
            if(preorder[i]<root.data){
                le=i;
            }else{
                rs=i;
                break;
            }
        }
        root.left=helper(preorder,ls,le);
        root.right=helper(preorder,rs,re);
        return root;
        
        
        
    }

    public static BinaryTreeNode<Integer> constructBST(int[] preorder) {
        //Write your code here
        int size=preorder.length;
        return helper(preorder,0, size-1);
    }
    
}
