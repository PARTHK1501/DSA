class Solution {
    
    String strs[];
    int n;
    
    public String encode(String s[]) {
        // write your logic to encode the strings
        StringBuilder encodedS = new StringBuilder();
        String strs[] = s;
        n = strs.length;
        
        for(String str:s){
            encodedS.append(str.length()).append('#').append(str);
        }
        
        return encodedS.toString();
    }

    public String[] decode(String s) {
        // write your logic to decode the string
        String[] ans = new String[n];
        int count = 0;
        int i = 0;
        
        while(i < s.length()){
            int j = i;
            while(s.charAt(j) != '#'){
                j++;
            }
            
            int length = Integer.parseInt(s.substring(i,j));
            i = j+1;
            j = i+length;
            
            ans[count++] = s.substring(i,j);
            i=j;
        }
        
        return ans;
    }
}