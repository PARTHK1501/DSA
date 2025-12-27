// 1st - Method using double for loops - bruteforce approach

class Solution {

    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (n != m)
            return false;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < m; i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
            if (map.get(t.charAt(i)) == 0) {
                map.remove(t.charAt(i));
            }
        }

        return map.isEmpty();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int n=strs.length;
        List<List<String>> ans= new ArrayList<>();
        boolean[] check = new boolean[n];

        for(int i=0;i<n;i++){

            if(check[i] == true) continue;

            String s1 = strs[i];
            List<String> temp = new ArrayList<>();
            temp.add(s1);
            check[i] = true;

            for(int j=i+1;j<n;j++){
                if(isAnagram(s1,strs[j])){
                    temp.add(strs[j]);
                    check[j] = true;
                }
            }

            ans.add(temp);
        }

        return ans;       
    }
}

// 2nd Method - Using HashMap to store pattern as key - Optimal approach.

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String s1 = new String(ch);
            map.computeIfAbsent(s1, k -> new ArrayList<>()).add(strs[i]);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }
}