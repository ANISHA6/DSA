import java.util.ArrayList;
import java.util.Collections;

public class Solution 
{
	//self created method to swap two elements
	public static void swap(ArrayList<Integer> p, int i, int j){
		int t=p.get(i);
		p.set(i, p.get(j));
		p.set(j, t);
		return;
	}
	//self created method to reverse the list
	public static void reverse(ArrayList<Integer> p, int i, int j){
		while(i<j){
			swap(p, i, j);
			i++;
			j--;
		}
		return;
	}
	
	//method, which we have to complete
	public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) 
	{
		// Write your code here.
		
		int n=permutation.size();
		if(n<=1){
			return permutation;// return same list if size is 0 or 1
		}
		int i=n-2;
		
		//in lexographical order, list is in sorted order at certain point from back side
		// first we have to find the break point index
		while(i>=0 && permutation.get(i)>=permutation.get(i+1)){
			i--;
		}// here i will be first smaller element after the increasing oder from back side
		//e.g, 1 3 5 4 2 
		//i=1, at i, elem is 3
		
		
		//finding the element which is just grater than ith element
		//if found then swap
		if(i>=0){
			int j=n-1;
			//
			while(permutation.get(j)<=permutation.get(i)){
				j--;
				
			}
			//i=1, elm=3 ,,, j=3, elm=4
			//4 is just greater than 3 so swap it
			swap(permutation, i, j);
		}
		reverse(permutation, i+1, n-1);//reverse to get just greater permutation than given one.
		
		return permutation;
		

	}
}
