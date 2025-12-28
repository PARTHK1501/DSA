import javax.lang.model.SourceVersion;

public class trappingRainWater {
    public static int trap(int[] height){
        int n=height.length;
        int[] prefix = new int[n];
        int maxH = height[0];

        for(int i=1;i<n-1;i++){
            prefix[i] = maxH;
            maxH = Math.max(maxH,height[i]);
        }

        int[] suffix = new int[n];
        maxH = height[n-1];
        for(int i=n-2;i>0;i--){
            suffix[i] = maxH;
            maxH = Math.max(maxH,height[i]);
        }

        int maxTrapWater = 0;
        for(int i=1;i<n-1;i++){
            if(prefix[i] > height[i] && suffix[i] > height[i]){
                maxTrapWater += (Math.min(prefix[i],suffix[i]) - height[i]);
            }
        }

        return maxTrapWater;
    }

    public static void main(String[] args) {

        //int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height = {4,2,0,3,2,5};

        System.out.println(trap(height));
    }
}



//2nd - Method

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0,r = n-1;
        int maxL = height[l] , maxR = height[r];
        int ans = 0;

        while(l<r){
            
            if(maxL < maxR){
                l++;
                maxL = Math.max(maxL,height[l]);
                ans += maxL - height[l];
            }else{
                r--;
                maxR = Math.max(maxR,height[r]);
                ans += maxR - height[r];
            }
        }

        return ans;
    }
}