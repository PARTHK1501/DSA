//1st-Method

import java.util.HashSet;
import java.util.Set;

class Solution{

    public boolean isInclude(String s1,String s2){
        Set<Character> set=new HashSet<>();

        for(int i=0;i<s1.length();i++){
            set.add(s1.charAt(i));
        }

        for(int i=0;i<s2.length();i++){
            if(!set.contains(s2.charAt(i))) return false;
            set.remove(s2.charAt(i));
        }

        return true;
    }

    public boolean checkInclusion(String s1,String s2){
        int s1Length = s1.length();
        int s2Length = s2.length();

        int l = 0 , r = 0;

        while(r < s2Length){
            if(r-l+1 > s1.length()){
                l++;
            }
            if (r-l+1 == s1Length && isInclude(s1,s2.substring(l, r+1))) {
                return true;
            }
        }

        return false;
    }
}



//2nd - Method

class Solution {

    public boolean isMatch(int[] s1, int[] s2) {
        for (int i = 0; i < 26; i++) {
            if (s1[i] != s2[i])
                return false;
        }

        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m)
            return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (int i = 0; i < n; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < m - n; i++) {
            if (isMatch(s1Count, s2Count))
                return true;

            s2Count[s2.charAt(i + n) - 'a']++;
            s2Count[s2.charAt(i) - 'a']--;
        }

        return isMatch(s1Count, s2Count);
    }
}
