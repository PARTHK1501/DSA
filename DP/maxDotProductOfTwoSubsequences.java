class Solution {

    int m, n;
    int[][] dp;

    public int solve(int[] nums1, int[] nums2, int i, int j) {
        if (i == m || j == n) {
            return -1000000000;
        }

        if (dp[i][j] != -1000000000) {
            return dp[i][j];
        }

        int val = nums1[i] * nums2[j];
        int take_i_j = val + solve(nums1, nums2, i + 1, j + 1);
        int take_i = solve(nums1, nums2, i, j + 1);
        int take_j = solve(nums1, nums2, i + 1, j);

        dp[i][j] = Math.max(val, Math.max(take_i_j, Math.max(take_i, take_j)));

        return dp[i][j];
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        m = nums1.length;
        n = nums2.length;
        dp = new int[501][501];

        for (int i = 0; i < 501; i++) {
            Arrays.fill(dp[i], -1000000000);
        }

        return solve(nums1, nums2, 0, 0);
    }
}