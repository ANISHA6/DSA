import java.util.*;
public class Solution {	
    
    private static int pairSum(int[] arr, int SI,int EI, int num){
int numPair=0;
while(SI<EI){
if(arr[SI]+arr[EI]<num){
SI++;
}
else if(arr[SI]+arr[EI]>num){
EI--;
}else{
int elementAtStart = arr[SI];
int elementAtEnd=arr[EI];
if(elementAtStart==elementAtEnd){
int totalElementsFromStartToEnd = (EI-SI)+1;
numPair+=(totalElementsFromStartToEnd*(totalElementsFromStartToEnd-1)/2);
return numPair;
}
int tempSI = SI+1;
int tempEI=EI-1;
while(tempSI<=tempEI && arr[tempSI]==elementAtStart){
tempSI+=1;
}
while(tempEI>=tempSI && arr[tempEI]==elementAtEnd){
tempEI-=1;
}
int totalElementsFromStart = (tempSI-SI);
int totalElementsFromEnd =(EI-tempEI);
    
    numPair+=(totalElementsFromStart*totalElementsFromEnd);

SI=tempSI;
EI=tempEI;
}
}
return numPair;
}




	public static int tripletSum(int[] arr, int num) {
		//Your code goes here
      
 Arrays.sort(arr);
  int n=arr.length;
int numTriplets=0;

for(int i=0;i<n;i++){
int pairSumFor=num-arr[i];
int numPairs=pairSum(arr,(i+1),(n-1),pairSumFor);//same function for finding pair sum.
numTriplets+=numPairs;
}
return numTriplets;
  }
}
