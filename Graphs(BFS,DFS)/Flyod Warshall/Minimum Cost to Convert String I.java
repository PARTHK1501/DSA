class Solution {

    public void flyodAlgo(long[][] dist, char[] original, char[] changed, int[] cost) {
        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';

            dist[u][v] = Math.min(dist[u][v], (long) cost[i]);
        }

        for (int via = 0; via < 26; via++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                }
            }
        }
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] dist = new long[26][26];

        for (int i = 0; i < 26; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        flyodAlgo(dist, original, changed, cost);

        long ans = 0;

        for (int i = 0; i < source.length(); i++) {

            if (source.charAt(i) == target.charAt(i)) {
                continue;
            }

            if (dist[source.charAt(i) - 'a'][target.charAt(i) - 'a'] == Integer.MAX_VALUE) {
                return -1;
            } else {
                ans += dist[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
            }
        }

        return ans;
    }
}