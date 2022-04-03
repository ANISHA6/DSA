import java.util.*;
public class Solution{

	public static void itineary(HashMap<String, String> input) {
		// TODO Auto-generated method stub
        HashMap<String, String> reverseMap=new HashMap<>();
       
        
        //Reversing the hashmap, to find the starting city
        for(Map.Entry<String, String> entry:input.entrySet()){
         reverseMap.put(entry.getValue(), entry.getKey());
        }
        String str=null;
        
        for(Map.Entry<String, String> entry:input.entrySet()){
            if(!reverseMap.containsKey(entry.getKey())){
                str=entry.getKey();
                break;
            }
        }

        if(str==null){
            return;
        }
        
        String to=input.get(str);
        while(to!=null){
            System.out.println(str+" -> "+ to);
            str=to;              
            to=input.get(to);
        }
       
        
		
	}
	
}
