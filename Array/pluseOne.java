class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int idx = n - 1;

        while (idx >= 0) {
            if (digits[idx] != 9) {
                digits[idx] = digits[idx] + 1;
                return digits;
            }

            digits[idx] = 0;
            idx--; //[1,2,9,9,9]
        }

        int[] ans = new int[n + 1];
        ans[0] = 1;

        return ans;
    }
}