public class Solution {


	static int findstart(Fuel_Pair[] arr, int n) {
		/*
			* Your class should be named Solution.
			* Write your code here
		 */
        
        int begin=0;
        int end=1;
        int petrolnow=arr[begin].petrol-arr[begin].distance;
        
        while(end!=begin || petrolnow<0){
            while(petrolnow<0 && begin!=end){
                petrolnow-=arr[begin].petrol-arr[begin].distance;
                begin=(begin+1)%n;
                if(begin==0){
                    return -1;
                }
            }
            petrolnow+=arr[end].petrol-arr[end].distance;
            end=(end+1)%n;
        }
        return begin;
  }
}
