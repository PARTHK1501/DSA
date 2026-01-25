class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int time = 0;

        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.add(freq[i]);
            }
        }

        while (!pq.isEmpty()) {

            List<Integer> temp = new ArrayList<>();
            for (int i = 1; i <= n + 1; i++) {

                if (!pq.isEmpty()) {
                    int frq = pq.poll();
                    frq--;
                    temp.add(frq);
                }
            }

            for (int num : temp) {
                if (num > 0) {
                    pq.add(num);
                }
            }

            if (pq.isEmpty()) {
                time += temp.size();
            } else {
                time += (n + 1);
            }
        }

        return time;
    }
}