class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        //Assumed
        int min_height=height[0];
        int max_height=height[n-1];
        int min_idx=0;
        int max_idx=n-1;
        
        if(max_height<  min_height){
            min_height=max_height;
            min_idx=max_idx;
             max_height=height[0];
            max_idx=0;
        }
        
        int width=n-1;
        
        int max_area=min_height * width;
        
        
        while(width>0){
            int idx=min_idx;
            
            while(height[idx]<=min_height){
                if(min_idx<max_idx){
                    idx++;
                }
                else{
                    idx--;
                }
                width--;//Do it,  while changging the index
                if(width<1){
                    break;
                }
            }
            
            if(height[idx]>max_height){
                min_height=max_height;
                min_idx=max_idx;
                max_height=height[idx];
                max_idx=idx;
            }
            else{
                min_height=height[idx];
                min_idx=idx;
            }
            
            max_area=Math.max(max_area, width*min_height);
            
            
        }
        return max_area;
        
        
    }
}
