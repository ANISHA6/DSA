class Solution {
    
    public static boolean isPalindrome(String str, int s, int e){
        while(s<=e){
            if(str.charAt(s)!=str.charAt(e)){
                return false;
            }
            s++;
            e--;
        }
        return true;
        
    }
    public static void palindromePartition(List<List<String>> list,List<String> paths,String str, int index){
        if(index==str.length()){
            list.add(new ArrayList<>(paths));
            
            return;
        }
        
        for(int i=index;i<str.length();i++){
            if(isPalindrome(str, index, i)){
                String s=str.substring(index, i+1);
                paths.add(s);
                palindromePartition(list, paths,str, i+1);
                paths.remove(paths.size()-1);// Backtracking step
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> list=new ArrayList<>();
        List<String> paths=new ArrayList<>();
        palindromePartition(list,paths, s, 0);
        return list;
        
    }
}
