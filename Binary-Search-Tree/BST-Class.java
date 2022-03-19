/*
 * Binary Tree Node class
 * 
 * class BinaryTreeNode<T> { 
 * 		T data; 
 * 		BinaryTreeNode<T> left; 
 * 		BinaryTreeNode<T> right;
 * 		public BinaryTreeNode(T data) 
 * 		{ 
 * 			this.data = data; 
 * 		}
 * }
 */

 /* 
 * Main Method being used internally
 *	public static void main(String[] args) throws IOException {
 *		BinarySearchTree bst = new BinarySearchTree();
 *		int choice, input;
 *		int q = Integer.parseInt(br.readLine());
 *		while (q-- > 0) {
 *			st = new StringTokenizer(br.readLine());
 *			choice = Integer.parseInt(st.nextToken());
 *			switch (choice) {
 *			case 1:
 *				input = Integer.parseInt(st.nextToken());
 *				bst.insert(input);
 *				break;
 *				case 2:
 *				input = Integer.parseInt(st.nextToken());
 *				bst.remove(input);
 *				break;
 *			case 3:
 *				input = Integer.parseInt(st.nextToken());
 *				System.out.println(bst.search(input));
 *				break;
 *			default:
 *				bst.printTree();
 *				break;
 *			}
 *		}
 *	}
 */

public class BinarySearchTree {
   BinaryTreeNode<Integer> root=null;
    
    
    public static BinaryTreeNode<Integer> helperi(BinaryTreeNode<Integer> root, int x){
        if(root==null){
            BinaryTreeNode<Integer> newnode=new BinaryTreeNode<Integer>(x);
            return newnode;
        }
        if(x>root.data){
            root.right=helperi(root.right,x);
        }
        else{
            root.left=helperi(root.left,x);
        }
        return root;
    }
	public void insert(int data) {
		//Implement the insert() function
        
        root=helperi(root,data);
	}
    
    public static int minvalue(BinaryTreeNode<Integer> root){
        int min=root.data;
        while(root.left!=null){
            min=root.left.data;
            root=root.left;
        }
        return min;
    }
    public static BinaryTreeNode<Integer> helperr(BinaryTreeNode<Integer> root, int x){
        if(root==null){
            return root;
        }
        
        //if both children are zero
        if(root.left==null && root.right==null){
            return null;
        }
        if(x<root.data){
            root.left=helperr(root.left, x);
        }
        else if(x>root.data){
            root.right=helperr(root.right,x);
        }else{
            //if it has only one child
            if(root.left==null && root.right!=null){
                return root.right;
            }
            else if(root.right==null && root.left!=null){
                return root.left;
                
                //if both children are present
            }else if(root.left!=null && root.right!=null){
            root.data=minvalue(root.right);// successor samllest in the right subtree
            root.right=helperr(root.right,root.data);
                return root;
        }
            else{
                return null;
            }
            
        }
        return root;
    }
	
	public void remove(int data) {
		//Implement the remove() function
        root=helperr(root,data);
        
    
	}
	public static void helperp(BinaryTreeNode<Integer> root){
        if(root==null){
            return;
        }
        
        System.out.print(root.data+":");
        if(root.left!=null){
            System.out.print("L:"+root.left.data+",");
        }if(root.right!=null){
            System.out.print("R:"+root.right.data);
        }
        System.out.println();
        helperp(root.left);
        helperp(root.right);
    }
	public void printTree() {
		//Implement the printTree() function
        helperp(root);
	}
    public static  boolean helpers(BinaryTreeNode<Integer> root,int x){
        if(root==null){
            return false;
        }
        if(root.data==x){
            return true;
        }
        if(x>root.data){
            return helpers(root.right,x);
        }
        else{
            return helpers(root.left,x);
        }
        
    }
	
	public boolean search(int data) {
		//Implement the search() function
        return helpers(root,data);
	}
	

}
