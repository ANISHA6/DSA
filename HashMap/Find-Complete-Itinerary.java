import java.util.*;
public class Solution{

	public static void itineary(HashMap<String, String> input) {
		// TODO Auto-generated method stub
        HashMap<String, String> reverseMap=new HashMap<>();        
        
        //Reversing the hashmap, to find the starting city
        for(Map.Entry<String, String> entry=input.entrySet){
         reversMap.put(entry.getValue(), entry.getKey());
        }
    //Initializing starting point with null
        String str=null;
        
        for(Map.Entry<String, String> entry=input.entrySet){
            if(!reverseMap.containsKey(entry.getKey()){
                str=entry.getKey();
                break;
            }
        }

        if(str==null){
            return;
        }
    //if, Starting point is found, then print source to destination with all path
    //str i source and input.get(str) is destination of that source
        while(str!=null){
            System.out.println(str+"->"+input.get(str));
            str=input.get(str);
        }
       
        
		
	}
	
}
