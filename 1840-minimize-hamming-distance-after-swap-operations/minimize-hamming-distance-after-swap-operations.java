class Solution {
    public void bfs(int curr, ArrayList<ArrayList<Integer>> adj, boolean vis[], ArrayList<Integer> list) {
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        vis[curr] = true;

        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            list.add(node);
            for(int child : adj.get(node)) {
                if(!vis[child]) {
                    vis[child] = true;
                    q.add(child);
                }
            }
        }
    }
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        int ans = 0;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int row[] : allowedSwaps) {
            adj.get(row[0]).add(row[1]);
            adj.get(row[1]).add(row[0]);
        }
        boolean vis[] = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                ArrayList<Integer> list = new ArrayList<>();
                bfs(i, adj, vis, list);

                ArrayList<Integer> temp1 = new ArrayList<>();
                ArrayList<Integer> temp2 = new ArrayList<>();

                for(int j = 0; j < list.size(); j++) {
                    temp1.add(source[list.get(j)]);
                    temp2.add(target[list.get(j)]);
                }

                HashMap<Integer, Integer> map = new HashMap<>();
                for(Integer val : temp1) {
                    map.put(val, map.getOrDefault(val, 0) + 1);
                }

                for(Integer val : temp2) {
                    if(map.containsKey(val)) {
                        map.put(val, map.get(val) - 1);
                        if(map.get(val) == 0) map.remove(val); 
                    } else {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}