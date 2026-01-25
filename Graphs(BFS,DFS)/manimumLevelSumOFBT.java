//1st - method BFS
class Solution {
    public int maxLevelSum(TreeNode root) {

        if(root == null) return 0;

        int maxSum = Integer.MIN_VALUE;
        int resultLevel = 0;
        int currLevel = 1;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int n = q.size();
            int sum = 0;

            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();

                sum += node.val;

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            if (sum > maxSum) {
                maxSum = sum;
                resultLevel = currLevel;
            }

            currLevel++;
        }

        return resultLevel;

    }
}


//2nd - Method DFS

class Solution {

    private Map<Integer, Integer> map;

    public void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        map.put(level, map.getOrDefault(level, 0) + root.val);
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    public int maxLevelSum(TreeNode root) {

        map = new HashMap<>();

        dfs(root, 1);

        int maxSum = Integer.MIN_VALUE;
        int ans = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int currlevel = entry.getKey();
            int sum = entry.getValue();

            if (sum > maxSum) {
                maxSum = sum;
                ans = currlevel;
            }
        }

        return ans;
    }
}