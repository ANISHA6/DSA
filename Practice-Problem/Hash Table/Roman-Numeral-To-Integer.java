import java.util.*;
/*
    Time Complexity     :   O(N)
    Space Complexity    :   O(N)

    Where 'N' is the length of the string.
*/
public class Solution {
    public static int romanToInt(String s) {
        // Write your code here
		HashMap<Character, Integer> map=new HashMap<>();
		int ans=0;
		map.put('I',1);
		map.put('V',5);
		map.put('X',10);
		map.put('L',50);
		map.put('C',100);
		map.put('D',500);
		map.put('M',1000);
		
		for(int i=0;i<s.length()-1;i++){
		char f=s.charAt(i);
		char e=s.charAt(i+1);
		if(map.get(f)>=map.get(e)){
		ans+=map.get(f);
		}else
		ans-=map.get(f);
		}
		
		ans+=map.get(s.charAt(s.length()-1));
		return ans;
		
		
    }
}
