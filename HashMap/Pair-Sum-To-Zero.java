import java.util.*;

public class Solution {
	public static int PairSum(int[] input, int size) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
        if(input.length==0 || input.length==1){
            return 0;
        }
        
        HashMap<Integer, Integer> map=new HashMap<>();
        int res=0;
        for(int i=0;i<size;i++){
            int key=input[i];
            if(map.containsKey(key)){
                int val=map.get(key);
                map.put(key,val+1);

            }else{
                map.put(key,1);
            }
        }
        
            for(int i=0;i<input.length;i++){
                int key=input[i];
                //case, to handle zero value
                if(key==0){
                    int count=map.get(key);
                    res+=count*(count-1)/2;
                    map.put(key,0);
                }
                else if(map.containsKey(-key) && map.containsKey(key)){
                    int f=map.get(-key);
                   int f1=map.get(key);
                    res+=f*f1;
                    map.put(-key,0);
                    map.put(key,0);
                }}

            
            
        return res;
	}
}
