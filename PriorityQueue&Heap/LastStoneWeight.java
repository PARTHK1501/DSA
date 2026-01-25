class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            pq.offer(stones[i]);
        }

        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();

            if (x != y) {
                pq.offer(y - x);
            }
        }

        return pq.size() == 0 ? 0 : pq.peek();
    }
}