class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long sum = 0;
        int negativeC = 0;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < 0) {
                    negativeC++;
                }
                minValue = Math.min(minValue, Math.abs(matrix[i][j]));
                sum += Math.abs(matrix[i][j]);
            }
        }

        return negativeC % 2 == 0 ? sum : sum - (2L * minValue);
    }
}