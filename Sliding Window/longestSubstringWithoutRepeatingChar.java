import java.util.Set;

class Solution{
    public int lengthOfLongestSubstring(String s){
        int n=s.length();
        Set<Character> set = new HashSet<>();
        int l = 0 , r = 0;
        int maxLenght = 0;

        while(r < n){
            if(!set.add(s.charAt(r))){
                while(set.contains(s.charAt(r))){
                    set.remove(s.charAt(l));
                    l++;
                }
            }

            set.add(s.charAt(r));
            int length = r - l + 1;
            maxLenght = Math.max(maxLenght,length);
            r++;
        }

        return maxLenght;
    }
}