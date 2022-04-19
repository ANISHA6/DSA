/*******************************************************

    Following is the Interval class structure

    class Interval {
        int start, int finish;

        Interval(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
    
*******************************************************/

import java.util.*;
import java.util.ArrayList;

public class Solution {
    public static List<Interval> mergeIntervals(Interval[] intervals) {
        // write your code here.
		
		if(intervals.length==0){
			return new ArrayList<Interval>();
		}
		
		List<Interval> ans=new ArrayList<>();
		Arrays.sort(intervals, (a,b)-> a.start-b.start);
      
      //Another way to sort the given array of type Interval
      
//        Arrays.sort(intervals, new Comparator<Interval>() {

//             public int compare(Interval a, Interval b) {
//                 if(a.start == b.start) {
//                     return a.finish - b.finish;
//                 }

//                 return a.start - b.start;
//             }
         
         
		int s=intervals[0].start;
		int e=intervals[0].finish;
		
		for(Interval x:intervals){
			if(x.start<=e){
				e=Math.max(e, x.finish);
			}else {
				Interval temp=new Interval(s, e);// if can not merge with the current intervals then add it to the ans.
				ans.add(temp);
				s=x.start;//update s and e with current intervals.
				e=x.finish;
			}
		}
		Interval temp=new Interval(s, e);//After merging with every intervals at last add it to the ans
				ans.add(temp);
		return ans;
		
		
		
		

    }
}
