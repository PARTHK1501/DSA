class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;

        if(nums[low]<=nums[high]) return nums[low];

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return nums[low];
    }
}