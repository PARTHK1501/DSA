class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int i=0,j=n-1;
        int max=0;

        while(i<j){
            int w=j-i;
            int h=Math.min(height[i],height[j]);
            int amountW=w*h;

            if(amountW>max){
                max=amountW;
            }

            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }

        return max;
    }
}
