//1st- method

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int counter = 0;
        int r = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        while (r < k) {
            pq.offer(nums[r]);
            r++;
        }

        ans[counter++] = pq.peek();
        pq.remove(nums[0]);

        for (int l = 1; l <= n - k; l++) {
            pq.offer(nums[r]);
            ans[counter++] = pq.peek();
            pq.remove(nums[l]);
            r++;
        }


        return ans;

    }
}

//2nd - Method

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int i = 0, j = 0, count = 0;
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        while (j < n) {
            while (!q.isEmpty() && q.peekLast() < nums[j]) {
                q.pollLast();
            }

            q.add(nums[j]);

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                ans[count++] = q.peek();

                if (nums[i] == q.peek()) {
                    q.poll();
                }
                i++;
                j++;
            }
        }

        return ans;
    }
}