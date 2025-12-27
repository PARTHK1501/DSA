import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums,int k){
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();

        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        List<Integer>[] bucket = new List[n+1];

        for(int key:map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int[] ans = new int[k];
        int counter = 0;

        for(int i = bucket.length-1 ; i >= 0 && counter < k ; i-- ){
            if(bucket[i] != null){
                for(int num : bucket[i]){
                    ans[counter++] = num;
                    if(counter == k) break;
                }
            }
        }

        return ans;
    }
}
