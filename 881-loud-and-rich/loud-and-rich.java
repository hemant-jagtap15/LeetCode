class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        ArrayList<ArrayList<Integer>> adj =  new ArrayList<>();
        int V = quiet.length;
        int ans[] = new int[V];

        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        } 
        for(int row[] : richer) {
            adj.get(row[1]).add(row[0]);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < V; i++) {
            map.put(quiet[i], i);
        }

        for(int i = 0; i < V; i++) {
            int val[] = new int[1];
            val[0] = quiet[i];
            boolean vis[] = new boolean[V];
            dfs(i, val, vis, adj, quiet);
            ans[i] = map.get(val[0]);
        }
        return ans;
    }

    public void dfs(int curr, int val[], boolean vis[], ArrayList<ArrayList<Integer>> adj, int quiet[]) {
        vis[curr] = true;

        for(int child : adj.get(curr)) {
            if(!vis[child]) {
                val[0] = Math.min(val[0], quiet[child]);
                dfs(child, val, vis, adj, quiet);
            }
        }
    }
}