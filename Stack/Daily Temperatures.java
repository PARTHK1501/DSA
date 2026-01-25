class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (temperatures[i] < temperatures[j]) {
                    ans[i] = j - i;
                    break;
                }
            }
        }

        return ans;
    }
}

// 2nd-Method Using stack
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<int[]> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            if (st.isEmpty()) {
                st.push(new int[] { temperatures[i], i });
                continue;
            }

            int[] arr = st.peek();
            int num = arr[0];
            int idx = arr[1];

            while (!st.isEmpty() && temperatures[i] > num) {
                ans[idx] = i - idx;
                st.pop();
                if (st.isEmpty())
                    break;
                arr = st.peek();
                num = arr[0];
                idx = arr[1];
            }

            st.push(new int[] { temperatures[i], i });
        }

        return ans;
    }
}