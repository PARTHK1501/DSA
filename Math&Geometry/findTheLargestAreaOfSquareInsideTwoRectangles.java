class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long minX = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                long maxX = Math.min(topRight[i][0], topRight[j][0]);
                long minY = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                long maxY = Math.min(topRight[i][1], topRight[j][1]);

                if (minX < maxX && minY < maxY) {
                    long side = Math.min(maxX - minX, maxY - minY);
                    maxArea = Math.max(maxArea, side * side);
                }
            }
        }

        return maxArea;
    }
}