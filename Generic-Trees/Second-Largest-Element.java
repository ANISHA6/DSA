 static TreeNode<Integer> first=new TreeNode<Integer>(Integer.MIN_VALUE);
 static TreeNode<Integer> second=first;

		public static void helper(TreeNode<Integer> root){
            if(root==null){
                return;
            }
            
                if(root.data>first.data){
                    second=first;
                    first=root;
                }else if(root.data!=first.data&&root.data>second.data){
                    second=root;
                    
                }
            
            
            for(TreeNode<Integer> child:root.children){
                helper(child);
            }
            
            
        }
	
	public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
 // Write your code here
       helper(root);
        return second;

	}
	
	
}
