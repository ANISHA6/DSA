import java.util.*;
public class Solution {

	public static void intersection(int[] arr1, int[] arr2) {
	    //Your code goes here
        
        if(arr1.length==0 && arr2.length==0){
            return;
        }
       Arrays.sort(arr1);//because, we have to print it in first sorted array
        HashMap<Integer, Integer> map=new HashMap<>();
        
        for(int i=0;i<arr2.length;i++){
            // if(map.containsKey(arr2[i])){
            //     int val=map.get(arr2[i]);
            //     map.put(arr2[i], val+1);
            // }else{
            //     map.put(arr2[i],1);
            // }
            //Another way to write above code
            map.put(arr2[i], map.getOrDefault(arr2[i], 0)+1);
        }
        for(int i=0;i<arr1.length;i++){
            if(map.containsKey(arr1[i])){
                int feq=map.get(arr1[i]);
                if(feq>0){
                    System.out.print(arr1[i]+" ");
                    map.put(arr1[i],feq-1);
                }
            }
        }
        
	}

}
