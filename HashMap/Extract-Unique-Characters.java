mport java.util.HashMap;

public class Solution {

	public static String uniqueChar(String str){
		 
        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            // if(map.containsKey(ch)){
            //     int val=map.get(ch);
            //     map.put(ch,val+1);
            // }else
            //     map.put(ch,1);
            // Alternate way to write above code
            map.put(ch, map.getOrDefault(ch, 0)+1);
     }
         String string="";// for ans
        
        
        for(int i=0;i<str.length();i++){
            int val=map.get(str.charAt(i));
            if(val>0){
                string+=str.charAt(i);
                map.put(str.charAt(i),0);
            }
        }
       
        return string;

        
        
        
        //More optimise way to write above code
        String st="";//for ans
         HashMap<Character, Boolean> map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
           if(!map.containsKey(ch)){
               map.put(ch, true);
               st+=ch;
           }
        }
        return st;
	}
}
