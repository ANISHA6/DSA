public class solution {
    public static void merge(int[] input1, int[] input2, int[] output){
        int l1=input1.length;
        int l2=input2.length;
        int i=0;
        int j=0;
        int k=0;
        
        while(i<l1 && j<l2){
            if(input1[i]<=input2[j]){
                output[k++]=input1[i];
                i++;
            }
            else{
                output[k++]=input2[j];
                j++;
            }
        }
        while(i<l1){
            output[k++]=input1[i++];
        }
        while(j<l2){
            output[k++]=input2[j++];
        }
        
    }

	public static void mergeSort(int[] input){
		// Write your code here
        
        int n=input.length;
        if(n==0 || n==1){
            return;
        }
        int mid=n/2;
        int part1[]=new int[mid];
        int part2[]=new int[n-mid];
        for(int i=0;i<mid;i++){
            part1[i]=input[i];
        }
        for(int j=mid;j<n;j++){
            part2[j-mid]=input[j];
        }
        mergeSort(part1);
        mergeSort(part2);
         merge(part1,part2,input);
        
   
		
	}
}
