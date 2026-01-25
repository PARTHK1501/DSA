class Solution {

    public int haveFourDivisors(int num) {
        int sum = 0;
        int countDivisors = 0;

        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                if (i * i == num) {
                    sum += i;
                    countDivisors++;
                } else {
                    sum += i + (num / i);
                    countDivisors += 2;
                }
            }

            if (countDivisors > 4)
                return 0;
        }

        return countDivisors == 4 ? sum : 0;
    }

    public int sumFourDivisors(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans += haveFourDivisors(nums[i]);
        }

        return ans;
    }
}