class Solution {
    public long requiredHour(int k, int[] p) {
        long hour = 0;
        for (int pile : p) {
            hour += (long) (pile + k - 1) / k;
        }
        return hour;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (requiredHour(mid, piles) <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}