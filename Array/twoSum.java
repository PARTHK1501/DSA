//1st Method - Using Double for loop -brute force

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;

        for(int i=0;i<n-1;i++){
            int num1 = nums[i];
            for(int j=i+1;j<n;j++){
                if(num1 + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }

        return new int[]{0,0};
    }
}


// 2nd Method - using HashMap to find target
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{0,0};
    }
}