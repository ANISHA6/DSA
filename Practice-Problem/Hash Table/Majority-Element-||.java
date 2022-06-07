import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) 
    {
        // Write your code here.
        
        ArrayList<Integer> ans=new ArrayList<>();
        HashMap<Integer, Integer> map=new HashMap<>();
        int n=arr.size();
        
        for(int i=0;i<n;i++){
            map.put(arr.get(i), map.getOrDefault(arr.get(i), 0)+1);

        }
        
        
        for(Map.Entry<Integer, Integer> m:map.entrySet()){
            if(m.getValue()> Math.floor(n/3)){
                ans.add(m.getKey());
            }
        }
        
        return ans;
    }
}
