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
        bfs(adj, vis);

        for(int i = 0; i < n; i++) {
            if(!vis[i]) return false;
        }

        return true;
    }

    public void bfs(ArrayList<ArrayList<Integer>> adj, boolean vis[]) {
        Queue<Integer> q =  new LinkedList<>();
        q.add(0);
        vis[0] = true;
        
        while(!q.isEmpty()) {
            int curr = q.peek();
            q.remove();

            for(int child : adj.get(curr)) {
                if(!vis[child]) {
                    q.add(child);
                    vis[child] = true;
                }
            }
        }
    }
}