//Method 1 using LinkedHashMap

import java.util.*;
public class Solution {
	public static String intToRoman(int num) {
		// Write your code here.
		Map<String, Integer> map=new LinkedHashMap<>();
		map.put("M", 1000);
		map.put("CM", 900);
		map.put("D", 500);
		map.put("CD", 400);
		map.put("C", 100);
		map.put("XC", 90);
		map.put("L", 50);
		map.put("XL", 40);
		map.put("X", 10);
		map.put("IX", 9);
		map.put("V", 5);
		map.put("IV", 4);
		map.put("I", 1);
		
		StringBuilder s=new StringBuilder();
		
		for(Map.Entry<String, Integer> m:map.entrySet()){
			while(num>=m.getValue()){
				num=num-m.getValue();
				s.append(m.getKey());
			}
		}
		return s.toString();
			
}
}
//Method 2

/*
	Time complexity: O(1)
	Space complexity: O(1)
    
*/

public class Solution {

	// Function that converts decimal to corresponding Roman Numerals.
	public static String intToRoman(int num) {

		/*
            Storing roman values of digits from 0-9
	        when placed at different places.
        */
		String m[] = { "", "M", "MM", "MMM" };
		String c[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String x[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String i[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

		// Converting diffrent places digits into roman.
		String thousands = m[num / 1000];
		String hundereds = c[(num % 1000) / 100];
		String tens = x[(num % 100) / 10];
		String ones = i[num % 10];

		StringBuilder ans = new StringBuilder();
		ans.append(thousands + hundereds + tens + ones);

		return ans.toString();
	}
}
