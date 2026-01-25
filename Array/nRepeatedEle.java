// 1st - Method
class Solution {
    public int repeatedNTimes(int[] nums) {
        int m = nums.length;
        int n = m / 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) == n)
                return num;
        }

        return 0;
    }
}

// 2nd - Method
class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> set=new HashSet<>();

        for(int num:nums){
            if(!set.add(num)) return num;
        }

        return 0;
    }
}