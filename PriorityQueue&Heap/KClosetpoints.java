class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));

        for (int i = 0; i < n; i++) {
            int x = points[i][0];
            int y = points[i][1];

            int distance = (x * x) + (y * y);

            pq.offer(new int[] { distance, i });
        }

        int[][] result = new int[k][2];

        for(int i=0;i<k;i++){
            int[] temp=pq.poll();
            int idx = temp[1];
            result[i] = points[idx];
        }

        return result;
    }
}