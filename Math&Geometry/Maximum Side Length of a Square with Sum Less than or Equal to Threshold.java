class Solution {

    private boolean squareExists(int[][] P, int m, int n, int len, int threshold) {
        
        for (int i = len; i <= m; i++) {
            for (int j = len; j <= n; j++) {
                int currentSum = P[i][j] - P[i-len][j] - P[i][j-len] + P[i-len][j-len];
                
                if (currentSum <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        
        int[][] P = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                P[i][j] = mat[i-1][j-1] + P[i-1][j] + P[i][j-1] - P[i-1][j-1];
            }
        }
        
        
        int low = 0, high = Math.min(m, n);
        int ans = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (squareExists(P, m, n, mid, threshold)) {
                ans = mid;      
                low = mid + 1;
            } else {
                high = mid - 1; 
            }
        }
        
        return ans;
    }
    
}