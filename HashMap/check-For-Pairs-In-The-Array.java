import java.util.*;
public class Solution {

	public static boolean ispairexist(int[] arr, int n, int k) {
		// TODO Auto-generated method stub
		//return false;
        if(n%2!=0){
            return false;
        }
        // One test case is not passing
        HashMap<Integer, Integer> map=new HashMap<>();
        
        //Storing remainder and its frequency
        for(int i=0;i<n;i++){
            int r=arr[i]%k;
            if(map.containsKey(r)){
                map.put(r, map.get(r)+1);
            }else
                map.put(r,1);
        }
        
        for(int i=0;i<n;i++){
            int r=arr[i]%k;
            if(!map.containsKey(k-r)){//complement of 1st element remainder(k-r) i.e second element is not present
                return false;
            }else{
                if(k-r==0){
                    if((map.get(k-r))%2!=0){//if element is 0, then frequency of 0 must be even
                        return false;
                    }
                }
               else if(k-r==k/2){//if element is half of k, then frequency of 0 must be even 
                    if( map.get(k-r)%2!=0){
                        return false;
                    }
                }else{
                   if(map.get(r)!=map.get(k-r)){//frequeny of both element must be equal
                       return false;
                   }
               }
                
            }
                map.put(r,0);
                map.put(k-r,0);
            
            }
        return true;
        
	}

}
