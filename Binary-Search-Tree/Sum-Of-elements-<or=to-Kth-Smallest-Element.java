import java.util.*;

public class Solution {
  static int sum=0;
    static int count=0;
//     static ArrayList<Integer> arr=new ArrayList<>();
    public static void helper(Node root, int k){
        if(root==null){
            return;
        }
               helper(root.left,k);
                arr.add(root.data);
               helper(root.right,k);
            
        
            return;
        }
	public static int solve(Node node, int k){

        helper(node,k);
        
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=arr.get(i);
        }
        
        return sum;

	}

}
