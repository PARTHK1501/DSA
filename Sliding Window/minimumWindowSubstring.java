class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (n > m)
            return "";

        Map<Character,Integer> map = new HashMap<>();

        for (int i=0;i<n;i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int l = 0, r = 0;
        int minWindowS = Integer.MAX_VALUE, start_idx = 0;
        int requiredCount = n;

        while (r < m) {

            char ch = s.charAt(r);

            if (map.containsKey(ch) && map.get(ch) > 0) {
                requiredCount--;
            }

            map.put(ch, map.getOrDefault(ch, 0) - 1);

            while (requiredCount == 0) {

                int sizeOfW = r - l + 1;

                if (sizeOfW < minWindowS) {
                    minWindowS = sizeOfW;
                    start_idx = l;
                }

                map.put(s.charAt(l), map.get(s.charAt(l)) + 1);

                if (map.get(s.charAt(l)) > 0) {
                    requiredCount++;
                }

                l++;
            }

            r++;
        }

        return minWindowS == Integer.MAX_VALUE ? "" : s.substring(start_idx, start_idx + minWindowS);
    }
}