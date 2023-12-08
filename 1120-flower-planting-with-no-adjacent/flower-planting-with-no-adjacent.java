class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int row[] : paths) {
            adj.get(row[0]-1).add(row[1]-1);
            adj.get(row[1]-1).add(row[0]-1);
        }

        int ans[] = new int[n];

        for(int i = 0; i < n; i++) {
            if(ans[i] == 0) {
                bfs(adj, i, ans);
            }
        }

        return ans;
    }

    public void bfs(ArrayList<ArrayList<Integer>> adj, int curr, int ans[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        ans[curr] = 1;

        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            int col = ans[node];

            for(int child : adj.get(node)) {
                if(ans[child] == 0 || ans[child] == col) {
                    ans[child] = col == 4 ? 1 : col + 1;
                    q.add(child);
                }
            }
        }
    }
}
