import java.util.*;
public class Solution {
    public static String getkey(String str){
        String key="";
        
        for(int i=1;i<str.length();i++){
            int diff=str.charAt(i)-str.charAt(i-1);//e.g, a-z=-26
            if(diff<0){
                diff+=26;//-26+26=0
            }
            key+=diff+"a";//a
        }
        return key;
    }

	public static void grouping(String[] arr, int n) {
		// TODO Auto-generated method stub
        HashMap<String,ArrayList<String>> map=new HashMap<>();
        //here key the diff b/w consecutve characters of string
        //and value is group of string with ame diff
        
        for(int i=0;i<n;i++){
            String s=arr[i];
            String key=getkey(s);
            if(map.containsKey(key)==false){
                ArrayList<String> list=new ArrayList<>();
                list.add(s);
                map.put(key,list);
                
            }else{
                ArrayList<String> l=map.get(key);//getting reference of arraylit
                l.add(s);
            }
        }
            
            for(ArrayList<String> list:map.values()){
                for(String st:list){
                    System.out.print(st+" ");//printing one group values in on line
                }
                System.out.println();
            }
            
        }
		
	}


