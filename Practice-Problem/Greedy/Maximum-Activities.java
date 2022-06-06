
import java.util.*;
class activity{
    int s;
    int e;
    activity(int s, int e){
        this.s=s;
        this.e=e;
    }
}

class activityComparator implements Comparator<activity>{
    @Override
    public int compare(activity o1, activity o2){
        if(o1.e<o2.e)
            return -1;
        
            return 1;
        
    }
}
public class Solution {
    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        //Write your code here
          int n=start.size();
        ArrayList<activity> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(new activity(start.get(i), end.get(i)));
        }
      
        activityComparator ac=new activityComparator();
        Collections.sort(arr, ac);
        int count=1;
        
        int et=arr.get(0).e;
        
        
        for(int i=1;i<arr.size();i++){
            if(arr.get(i).s>=et){
                count++;
                et=arr.get(i).e;
            }
            
        }
        return count;
        
        
    }
}
