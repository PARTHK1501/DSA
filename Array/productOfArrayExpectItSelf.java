// 1st - method

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] prefixP = new int[n];
        int[] suffixP = new int[n];
        int[] ans = new int[n];
        int product = 1;

        for(int i=0;i<n;i++){
            prefixP[i] = product;
            product *= nums[i];
        }

        product = 1;

        for(int i=n-1;i>=0;i--){
            suffixP[i] = product;
            product *= nums[i];
        }

        for(int i=0;i<n;i++){
            ans[i] = prefixP[i] * suffixP[i];
        }

        return ans;
    }
}

//2nd - Method

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] ans = new int[n];
        int product = 1;

        for(int i=0;i<n;i++){
            ans[i] = product;
            product *= nums[i];
        }

        product = 1;

        for(int i=n-1;i>=0;i--){
            ans[i] *= product;
            product *= nums[i];
        }

        return ans;
    }
}
