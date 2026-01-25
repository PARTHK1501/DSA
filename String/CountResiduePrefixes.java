class Solution{
    public int residuePrefixes(String s){
        int n=s.length();
        Set<Character> set=new HashSet<>();
        int ans = 0;

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(!set.contains(ch)){
                set.add(ch);
            }

            if(set.size() == (i-0+1)%3){
                ans++;
            }
        }

        return ans;
    }
}