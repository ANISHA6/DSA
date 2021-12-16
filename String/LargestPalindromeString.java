public class Main {
    public static void stringchange(String str, int k){
        int s=0;
        int e=str.length()-1;
        char[] newstr=str.toCharArray();
        
        while(s<e){
            if(str.charAt(s)!=str.charAt(e)){
                char max;
                if(str.charAt(s)>str.charAt(e)){
                    max=str.charAt(s);
                }
                else
                    max=str.charAt(e);
            
            newstr[s]=newstr[e]=max;
            k--;
            }
            
            s++;
            e--;
        }
        if(k<0){
            System.out.println("NOT POSSIBLE");
            return ;
        }
        s=0;
        e=str.length()-1;
        while(s<=e){
            if(s==e){
                if(k>0){
                    newstr[s]='9';
                }
            }
            if(k>=2 && (str.charAt(s)==newstr[s] && str.charAt(e)==newstr[e])){
                newstr[s]=newstr[e]='9';
                k-=2;
            }
            else if(k>=1 && ((str.charAt(s)!=newstr[s])||(str.charAt(e)!=newstr[e]))){
                newstr[s]=newstr[e]='9';
                k--;
            } 
            s++;
            e--;
        }
        
        System.out.println(newstr);
        
    }
        
    
