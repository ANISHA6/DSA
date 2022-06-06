public class Solution
{
public static int findMinimumCoins(int amount)
    {
        // Write your code here.
    int[] arr={1,2,5,10,20,50,100,500,1000};
    int count=0;
    for(int i=arr.length-1;i>=0;i--){
        while(amount>=arr[i]){
            amount-=arr[i];
            count++;
        }
    }
    return count;
    }
}
