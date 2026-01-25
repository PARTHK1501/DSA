class Solution {
    int M = 1_000_000_007;

    String[] states = { "RYR", "RGR", "RYG", "RGY", "YRY", "YGY", "YRG", "YGR", "GRG", "GYG", "GYR", "GRY" };
    int[][] t;

    public int solve(int n, int prevI) {
        if (n == 0) return 1;

       
        if (t[n][prevI] != -1) return t[n][prevI];

        String lastS = states[prevI];
        long result = 0; 

        for (int currI = 0; currI < 12; currI++) {
            String currS = states[currI];
            boolean conflict = false;

            for (int col = 0; col < 3; col++) {
                if (currS.charAt(col) == lastS.charAt(col)) {
                    conflict = true;
                    break;
                }
            }

            if (!conflict) {
                result = (result + solve(n - 1, currI)) % M;
            }
        }

        return t[n][prevI] = (int) result;
    }

    public int numOfWays(int n) {
        
        t = new int[n + 1][12];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 12; j++) {
                t[i][j] = -1;
            }
        }

        long totalResult = 0;
        for (int i = 0; i < 12; i++) {
            totalResult = (totalResult + solve(n - 1, i)) % M;
        }

        return (int) totalResult;
    }
}