class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int dist[][] = new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
           Arrays.fill(dist[i], Integer.MAX_VALUE);
           dist[i][i] = 0;
           if(i < n) {
               dist[i][i+1] = 1;
           }
           if(i > 1) {
               dist[i][i-1] = 1;
           }
        }

        dist[x][y] = 1;
        dist[y][x] = 1;

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(dist[i][j] != Integer.MAX_VALUE && i != j) {
                    map.put(dist[i][j], map.getOrDefault(dist[i][j], 0) + 1);
                }
            }
        }

        int ans[] = new int[n];
        for(int k = 1; k <= n; k++) {
            ans[k-1] = map.getOrDefault(k, 0);
        }
        return ans;
    }
}