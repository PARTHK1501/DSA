class Solution {

    int m, n;
    int[][] dp;

    public int solve(int i, int j, String s1, String s2) {
        if (i >= m && j >= n) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (i >= m) {
            return dp[i][j] = (int) s2.charAt(j) + solve(i, j + 1, s1, s2);
        }

        if (j >= n) {
            return dp[i][j] = (int) s1.charAt(i) + solve(i + 1, j, s1, s2);
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = solve(i + 1, j + 1, s1, s2);
        }

        int delte_i = (int) s1.charAt(i) + solve(i + 1, j, s1, s2);
        int delte_j = (int) s2.charAt(j) + solve(i, j + 1, s1, s2);

        return dp[i][j] = Math.min(delte_i, delte_j);
    }

    public int minimumDeleteSum(String s1, String s2) {
        m = s1.length();
        n = s2.length();

        dp = new int[1001][1001];

        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        return solve(0, 0, s1, s2);
    }
}