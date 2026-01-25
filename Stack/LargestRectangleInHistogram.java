class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int idx = st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();

                maxArea = Math.max(maxArea, heights[idx] * (nse - pse - 1));
            }

            st.push(i);
        }

        while (!st.isEmpty()) {
            int currIdx = st.pop();
            int nse = n;
            int pse = st.isEmpty() ? -1 : st.peek();

            maxArea = Math.max(maxArea, heights[currIdx] * (nse - pse - 1));
        }

        return maxArea;
    }
}