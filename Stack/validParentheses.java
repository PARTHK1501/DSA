import java.util.*;

class Solution{
    public boolean isValid(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);

            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }

            if((ch == ')' && st.peek() == '(') || (ch == ']' && st.peek() == '[') || (ch == '}' && st.peek() == '{')){
                st.pop();
            }
        }

        return st.isEmpty();
    }
}