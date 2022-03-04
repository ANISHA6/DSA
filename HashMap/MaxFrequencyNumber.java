import java.util.*;
public class Solution {

    public static int maxFrequencyNumber(int[] arr){ 
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
        HashMap<Integer, Integer> map=new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            // if(map.containsKey(arr[i])){
            //     map.put(arr[i],map.get(arr[i])+1);
            // }else
            //     map.put(arr[i],1);
            //Another way to write above code
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        int count=0;
        int res=-1;
        
//         for(int i=0;i<arr.length;i++){
//             if(map.containsKey(arr[i])){
//             int val=map.get(arr[i]);
//                 if(val>count){
//                     count=val;
//                 res=arr[i];
//                 }                
                
//             }
            
//         }
        
        //Another way to write above code
        for(int i:arr){
            if(map.get(i)>count){
                res=i;
                count=map.get(i);
        }
        
    }
      
        return res;
    }
}

