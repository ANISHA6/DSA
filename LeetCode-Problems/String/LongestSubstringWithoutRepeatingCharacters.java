class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0, j=0, max=0;
        HashSet<Character> set=new HashSet<>();
        int len=s.length();
        while(i<len && j<len){
            char ch=s.charAt(j);
            if(!set.contains(ch)){
                set.add(ch);
                j++;
                max=Math.max(max, j-i);
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
        
    }
}
