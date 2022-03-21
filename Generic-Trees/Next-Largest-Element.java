
	public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
		
		// Write your code here
		if(root==null){
		return null;
		}  
        
         TreeNode<Integer> ans=null;
        if(root.data>n){
            ans=root;
            
        }
       
        for(int i=0;i<root.children.size();i++){
           TreeNode<Integer> t= findNextLargerNode(root.children.get(i),n);
            if(t!=null){
            if(ans==null || ans.data>t.data){
                ans=t;
               }
            }
        }
        return ans;
    }
        
