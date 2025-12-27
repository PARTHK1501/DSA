// 1st - Method

class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int i=0;
        int j=s.length()-1;

        while(i<j){
            char f=s.charAt(i);
            char b=s.charAt(j);

            if(!(f>='a' && f<='z' || f>='0' && f<='9')){
                i++;
                continue;
            }

            if(!(b>='a' && b<='z' || b>='0' && b<='9')){
                j--;
                continue;
            }

            if(f != b){
                return false;
            }
            i++;
            j--;

        }
        return true;
    }
}


//2nd Method

class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int n = s.length();

        int i = 0, j = n - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }
}