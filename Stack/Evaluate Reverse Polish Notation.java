// 1st - Method Using if-else statment

class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int num2 = st.pop();
                int num1 = st.pop();

                if (tokens[i].equals("+")) {
                    st.push(num1 + num2);
                } else if (tokens[i].equals("-")) {
                    st.push(num1 - num2);
                } else if (tokens[i].equals("*")) {
                    st.push(num1 * num2);
                } else if (tokens[i].equals("/")) {
                    st.push((int) (num1 / num2));
                }
            } else {
                int num = Integer.parseInt(tokens[i]);
                st.push(num);
            }
        }

        return st.peek();
    }
}


// 2nd - Method Switch case

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String s : tokens) {
            // Check if the current token is an operator
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int num2 = st.pop();
                int num1 = st.pop();

                // Switch handles string content comparison automatically
                switch (s) {
                    case "+": st.push(num1 + num2); break;
                    case "-": st.push(num1 - num2); break;
                    case "*": st.push(num1 * num2); break;
                    case "/": st.push(num1 / num2); break;
                }
            } else {
                // If it's a number, parse and push it
                st.push(Integer.parseInt(s));
            }
        }

        return st.peek();
    }
}