import java.util.*;
public class Solution {
	
//    Time Complexity: O(N*2^N)
//     Space Complexity: O(N*2^N)

	public static void helper(int n, ArrayList<Integer> arr, int i, ArrayList<Integer> ans){
		if(i==n){
			if(ans.size()>0){
			Collections.sort(ans);
				
				for(int j=0;j<ans.size();j++){
				System.out.print(ans.get(j)+" ");
					
				}
				System.out.println();
			}
				return ;
			
		}
			ArrayList<Integer> tempAns=new ArrayList<>(ans);
			tempAns.add(arr.get(i));
			
			helper(n, arr, i+1, ans);
			helper(n, arr, i+1, tempAns);
			
			
		}
	
    static void printAllSubsets(int n, ArrayList<Integer> arr) {
        // Write your code here.
      
//       Method1 using bit masking
      
      /*
    Time Complexity: O(N*2^N)
    Space Complexity: O(N*2^N)

    where N is the size of given input array.
*/
			ArrayList<Integer> ans=new ArrayList<>();
		helper(n, arr, 0, ans);
		
//Method 2 using bit masking
		if(n==0){
			return ;
		}
		
		for(int i=1;i<Math.pow(2, n);i++){
			ArrayList<Integer> ans=new ArrayList<>();
			for(int j=0;j<n;j++){
				if((i &(1<<j))==(1<<j)){
					ans.add(arr.get(j));
				}
			}
			Collections.sort(ans);
			for(int k=0;k<ans.size();k++){
				System.out.print(ans.get(k) +" ");
			}
			System.out.println();
		}
    }

}
