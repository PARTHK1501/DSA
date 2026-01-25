class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int hMax = 1, vMax = 1;
        int prevN = hBars[0];
        int currMax = 1;

        for (int i = 1; i < hBars.length; i++) {
            if (hBars[i] == prevN + 1) {
                currMax++;
                hMax = Math.max(hMax, currMax);
            } else {
                currMax = 1;
            }

            prevN = hBars[i];
        }

        prevN = vBars[0];
        currMax = 1;

        for (int i = 1; i < vBars.length; i++) {
            if (vBars[i] == prevN + 1) {
                currMax++;
                vMax = Math.max(vMax, currMax);
            } else {
                currMax = 1;
            }

            prevN = vBars[i];
        }

        int min = Math.min(hMax,vMax)+1;

        return min*min;
    }
}