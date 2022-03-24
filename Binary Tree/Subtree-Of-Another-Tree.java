/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
        public boolean isSametree(TreeNode t, TreeNode s) {
            if(t==null || s==null){
                return t==null && s==null;
            }else if(t.val==s.val){
                return isSametree(t.left, s.left) && isSametree(t.right, s.right);
            }else{
                return false;
            }
        }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null){
            return false;
        }else if(isSametree(root, subRoot)){
            return true;
        }else{
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
        
    }
}
