
public class Solution {


	public static void merge(int arr1[], int m, int arr2[], int n) {
		
		// Write your code here
        
  PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.offer(arr2[i]);
        }
        for(int i=0;i<m;i++){
            if(arr1[i]>pq.peek()){
                int j=0;
                arr2[j]=pq.poll();
                int temp=arr1[i];
                arr1[i]=arr2[j];
                arr2[j]=temp;
                pq.offer(arr2[j]);
                
            }
        }
        for(int i=0;i<n;i++){
            arr2[i]=pq.poll();
        }
	}

}
