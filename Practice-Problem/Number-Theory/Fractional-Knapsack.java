/****************************************************************

    Following is the class structure of the Pair class:

        class Pair
        {
        	int weight;
	        int value;
	        Pair(int weight, int value)
	        {
		        this.weight = weight;
		        this.value = value;
	        }
	        
        }
        
*****************************************************************/

import java.util.*;
class itemComparator implements Comparator<Pair>{
    @Override
    public int compare(Pair a, Pair b){
        double r1=(double) (a.value)/(double)(a.weight);
        double r2=(double) (b.value)/(double)(b.weight);
        if(r1<r2) return 1;
        else if(r1>r2) return -1;
        else return 0;
        
        
    }
}

public class Solution {
    public static double maximumValue(Pair[] items, int n, int w) {
            // Write your code here.
    	    // ITEMS contains {weight, value} pairs.
        Arrays.sort(items,  new itemComparator());
        int currentWeight=0;
        double finalValue=0.0;
        
        for(int i=0;i<n;i++){
            if(currentWeight+items[i].weight <=w){
                currentWeight+=items[i].weight;
                finalValue+=items[i].value;
            }else{
                int remain=w-currentWeight;
                finalValue+=((double)items[i].value/ (double) items[i].weight) * (double) remain;
                break;
            }
        }
        return finalValue;
        
    }
}
