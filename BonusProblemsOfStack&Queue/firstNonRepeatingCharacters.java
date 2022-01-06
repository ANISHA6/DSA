public static void nonrep(String str) {
        //Write your code here
       
       if(str.length()==0){
          System.out.print("-1");
            return;
       }
        int[] arr=new int[26];
        Queue<Character> q=new LinkedList<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            arr[ch-'a']+=1;
            q.add(ch);
            
        
        while(!q.isEmpty()){
            if(arr[q.peek()-'a']>1){
                q.poll();
            }
            else{
                System.out.print(q.peek());//first non-repeating characters till ith characters
                break;
            }
        }
        if(q.isEmpty()){
            System.out.print("-1");//if no non-repeating characters is present then print -1
        }
        
    }
    
}
