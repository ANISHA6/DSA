
import java.util.*;


public class Solution {

	public static void findMedian(int arr[])  {
        
        
        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
    
        PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder());
         PriorityQueue<Integer> min=new PriorityQueue<>();
        
        int medium;
        for(int i=0;i<arr.length;i++){
            if(!max.isEmpty() && arr[i]>max.peek()){
                min.add(arr[i]);
            }
            else{
                max.add(arr[i]);
            }
            if(Math.abs(max.size()-min.size())>1){
                if(max.size()>min.size()){
                    int temp=max.poll();
                    min.add(temp);
                }else{
                    max.add(min.poll());
                }
            }
            int totalsize=max.size()+min.size();
            if(totalsize%2==1){
                if(max.size()>min.size()){
                    medium=max.peek();
                }else
                    medium=min.peek();
                
            }else
                medium=(max.peek()+min.peek())/2;
            System.out.print(medium+" ");
            
        }
    }


}
