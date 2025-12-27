// 1st - Method using sorting TC- n logn

class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        Arrays.sort(nums);
        int longestCS = 1;
        int ans = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1])
                continue;

            if (nums[i] == nums[i - 1] + 1) {
                longestCS++;
            } else {
                longestCS = 1;
            }

            ans = Math.max(ans, longestCS);
        }

        return ans;
    }
}

//2nd - Method Using set - TC - O(n)

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int ans = 0;

        for(int num:nums) set.add(num);

        for(int num:set){

            if(!set.contains(num-1)){
                int currNum = num;
                int longestStreak = 1;

                while(set.contains(currNum+1)){
                    currNum++;
                    longestStreak++;
                }

                ans = Math.max(ans,longestStreak);

            }
        }

        return ans;
    }
}