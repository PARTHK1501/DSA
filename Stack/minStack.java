class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> minStack;

    public MinStack() {
        st = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if (st.isEmpty() && minStack.isEmpty()) {
            st.push(val);
            minStack.push(val);
        } else {
            st.push(val);
            minStack.push(Math.min(val, minStack.peek()));
        }
    }

    public void pop() {
        if (st.isEmpty())
            return;

        st.pop();
        minStack.pop();
    }

    public int top() {
        if (st.isEmpty())
            return -1;

        return st.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}