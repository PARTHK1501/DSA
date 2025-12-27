// 1st - Method using HashMap

class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                return true;
            }
            map.put(nums[i],1);
        }

        return false;    
    }
}

// 2nd - Method using Set

class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        
        return false;    
    }
}