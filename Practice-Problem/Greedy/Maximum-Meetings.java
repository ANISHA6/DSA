import java.util.*;

class meeting{
    int s;
    int e;
    int pos;
    
    meeting(int s, int e, int pos){
        this.s=s;
        this.e=e;
        this.pos=pos;
    }
}
class meetingComparator implements Comparator<meeting>{
    @Override
    public int compare(meeting o1, meeting o2){
        if(o1.e<o2.e)
            return -1;
        else if(o1.e > o2.e)
            return 1;
        else if(o1.pos<o2.pos)
            return -1;
        return 1;
    }
}

public class Solution {
    public static List<Integer> maximumMeetings(int[] start, int[] end) {        
        //Write your code here
        int n=start.length;
        ArrayList<meeting> meet=new ArrayList<>();
        for(int i=0;i<n;i++){
            meet.add(new meeting(start[i], end[i], i+1));
        }
        meetingComparator mc=new meetingComparator();
        Collections.sort(meet, mc);
        List<Integer> ans=new ArrayList<>();
        ans.add(meet.get(0).pos);
        int limit=meet.get(0).e;
        
        for(int i=1;i<n;i++){
            if(meet.get(i).s>limit){
                limit=meet.get(i).e;
                ans.add(meet.get(i).pos);
            }
        }
        return ans;
    }
}
