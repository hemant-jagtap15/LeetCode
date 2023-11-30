class Solution {
    public int countArrangement(int n) {
        boolean vis[] = new boolean[n + 1];
        return ways(1, n, vis);
    }

    public int ways(int idx, int n, boolean vis[]) {
        if(idx > n) {
            return 1;
        }
        int cnt = 0;

        for(int i = 1; i <= n; i++) {
            if((idx % i == 0 || i % idx == 0) && !vis[i]) {
                vis[i] = true;
                cnt += ways(idx+1, n, vis);
                vis[i] = false;
            }
        }
        return cnt;
    }
}
