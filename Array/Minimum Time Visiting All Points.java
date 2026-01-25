class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int minTime = 0;
        int prevX = points[0][0];
        int prevY = points[0][1];

        for (int i = 1; i < points.length; i++) {

            int currX = points[i][0];
            int currY = points[i][1];

            minTime += Math.max(Math.abs(currX - prevX), Math.abs(currY - prevY));

            prevX = currX;
            prevY = currY;
        }

        return minTime;
    }
}