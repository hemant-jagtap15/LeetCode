class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = rooms.size();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++) {
            for(Integer val : rooms.get(i)) {
                adj.get(i).add(val);
            }
        }
        boolean vis[] = new boolean[n];
        dfs(adj, 0, vis);

        for(int i = 0; i < n; i++) {
            if(!vis[i]) return false;
        }

        return true;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, int curr, boolean vis[]) {
        vis[curr] = true;
        for(int child : adj.get(curr)) {
            if(!vis[child]) {
                dfs(adj, child, vis);
            }   
        }
    }
}