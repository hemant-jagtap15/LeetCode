class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        int indegree[] = new int[n+1];
        for(int row[] : relations) {
            adj.get(row[0]).add(row[1]);
            indegree[row[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int maxTime[] = new int[n+1];
        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0) q.add(i);
            maxTime[i] = time[i-1];
        }

        while(!q.isEmpty()) {
            int node = q.remove();
            for(int child : adj.get(node)) {
                maxTime[child] = Math.max(maxTime[child], maxTime[node] + time[child-1]);
                indegree[child]--;
                if(indegree[child] == 0) {
                    q.add(child);
                }
            }
        }

        int ans = 0;
        for(int i = 1; i <= n; i++) {
            ans = Math.max(ans, maxTime[i]);
        }
        return ans;
    }
}