import java.util.ArrayList;

public class Solution {
	public static ArrayList<ArrayList<Long>> printPascal(int n) {
                 // Write your code here.
		ArrayList<ArrayList<Long>> ans= new ArrayList<ArrayList<Long>>();
			
			ArrayList<Long> row, pre=null;
		
		for(int i=0;i<n;i++){
			row=new ArrayList<Long>();
			for(int j=0;j<=i;j++){
				if(j==0 ||j==i){
					row.add((long) 1);
				}else{
					row.add((long)pre.get(j-1)+pre.get(j));
				}
			}
			pre=row;
			ans.add(row);
		}
		return ans;
	}
}

//Different way to write above code
/*
	Time Complexity: O(N^2)
	Space complexity: O(N^2)
	
	Where N denotes the number of Rows.
*/

import java.util.ArrayList;

public class Solution {
	public static ArrayList<ArrayList<Long>> printPascal(int n) {
		ArrayList<ArrayList<Long>> triangle = new ArrayList<ArrayList<Long>>();

		for (int row = 0; row < n; row++) {
			ArrayList<Long> add = new ArrayList<Long>();
			for (int i = 0; i <= row; i++) {
				if (row == i || i == 0) {
					add.add((long) 1);
				} else {
					add.add(triangle.get(row - 1).get(i - 1) + triangle.get(row - 1).get(i));
				}
			}
			triangle.add(add);
		}
		return triangle;
	}
}

//Method 2
/*
	Time Complexity: O(N^2)
	Space complexity: O(1)
	
	Where N denotes the number of Rows.
*/

import java.util.ArrayList;

public class Solution {
	public static ArrayList<ArrayList<Long>> printPascal(int n) {
		ArrayList<ArrayList<Long>> triangle = new ArrayList<ArrayList<Long>>();

		for (int row = 1; row <= n; row++) {
			long rCe = 1;
			ArrayList<Long> add = new ArrayList<Long>();
			for (int i = 1; i <= row; i++) {

				add.add(rCe);
				rCe = rCe * (row - (long) i) / (long) i;
			}
			triangle.add(add);
		}
		return triangle;
	}
}


