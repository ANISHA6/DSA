import java.util.*;
public class Solution {

	public static int getPairsWithDifferenceK(int arr[], int k) {
		//Write your code here
        if(arr.length==0){
            return 0;
        }
        
       HashMap<Integer, Integer> map=new HashMap<>();
        
        for(int val: arr){
            if(map.containsKey(val)){//Add all value in hashmap with count
                int f=map.get(val);
                map.put(val,f+1);
            }
            else
                map.put(val,1);
            
        }
            int c=0;
        
        if(k==0){//To handle , if k=0 and all arr values are same
            int pair=map.get(arr[0]);
            c+=pair*(pair-1)/2;
        }else{
            for(int e:arr){
                int v=map.get(e);
                map.put(e,0);
                int f1=0;
               int f2=0;
                if(map.containsKey((e-k))){
                    f1=map.get(e-k);
                
                  
                }
                if(map.containsKey(e+k)){
                    f2=map.get(e+k);
            
                   
                }
                c+=v*f1+v*f2;
               
                 }
        }
           return c;
        
        
        
        
        //Method 2
        HashMap<Integer, Integer> map=new HashMap<>();
        int pairCount=0;
        for(int i:arr){
            int p1=i+k;
            boolean flag=false;
            if(p1==i){
                flag=true;
            }
            if(map.containsKey(p1)){
                pairCount+=map.get(p1);
            }
            int p2=i-k;
            if(map.containsKey(p2) && !flag){
                pairCount+=map.get(p2);
            }.
            map.put(i, map.getOrDefault(i, 0)+1);
            
        }
        return pairCount;
	}
}
