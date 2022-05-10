//Greedy approach
// Time Complexity
// O(N * maxDeadline), where ‘N’ denotes the number of elements of the array “jobs,” and ‘maxDeadline’ is the maximum available deadline among all the jobs.

 

// As for every index of the array “jobs”, we may have to search for all the indices of the array “slots”. Hence, the time complexity in the worst case will be O(N * maxDeadline).

// Space Complexity
// O(maxDeadline), where ‘maxDeadline’ is the maximum available deadline among all the jobs.

 

// The slots array/list has a size of maxDeadline.


import java.util.*;
public class Solution
{
    public static int jobScheduling(int[][] jobs)
    {
        // Write your code here
		Arrays.sort(jobs, (a,b)->(b[1]-a[1]));
		
		
// 		  Arrays.sort(jobs, new Comparator<int[]>(){
//         public int compare(int[] first, int[] second)
//         {
//             if(first[1] < second[1]) return 1;
//             else return -1;
//         }
//         });
		
		int n=jobs.length;
		int maxd=0;
		for(int i=0;i<n;i++){
			if(jobs[i][0]>maxd)
				maxd=jobs[i][0];
		}
		int[] result=new int[maxd+1];
		
		Arrays.fill(result, -1);
		int jobProfit=0;
		for(int i=0;i<n;i++){
			for(int j=jobs[i][0]; j>0;j--){
				//finding the free slot
				if(result[j]==-1){
					result[j]=i;
					jobProfit+=jobs[i][1];
					break;
				}
			}
		}
		return jobProfit;
		
    }
}


//using set

/*
    Time Complexity : O(N *log(max(N, maxDeadline)))
    Space Complexity : O(maxDeadline)

    Where 'N' is size of the array "jobs" and 
    'maxDeadline' is the maximum among all the deadlines.
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Solution
{
    // Sort the jobs in the decreasing order of their profit.
    public static int jobScheduling(int[][] jobs)
    {
        Arrays.sort(jobs, new Comparator<int[]>(){
        public int compare(int[] first, int[] second)
        {
            if(first[1] < second[1]) return 1;
            else return -1;
        }
        });

        int maxProfit = 0;
        int maxDeadline = 0;

        // Find the maximum deadline among all the jobs.
        for (int i = 0; i < jobs.length; i++)
        {
            maxDeadline = Math.max(maxDeadline, jobs[i][0]);
        }

        // Create a set "slots".
        TreeSet<Integer> set = new TreeSet<Integer>();

        // Insert all the elements from maxDeadline to 1 into the set.
        for (int i = maxDeadline; i > 0; i--)
        {
            set.add(i);
        }
        
        // Arrange elements of set in descending order
        TreeSet<Integer> slots = (TreeSet<Integer>)set.descendingSet();

        for (int i = 0; i < jobs.length; i++)
        {
            if (slots.size() == 0 || jobs[i][0] < slots.last())
            {
                continue;
            }

            Integer availableSlot = -1;

            for (Integer val : slots)
            {
                if (val <= jobs[i][0])
                {
                    availableSlot = val;
                    break;
                }
            }

            if (availableSlot != -1)
            {
                maxProfit = maxProfit + jobs[i][1];

                slots.remove(availableSlot);
            }
        }

        return maxProfit;
    }
}

