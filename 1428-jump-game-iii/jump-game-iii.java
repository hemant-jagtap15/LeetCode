class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++) {
            if(i + arr[i] >= 0 && i + arr[i] < n) {
                adj.get(i).add(i + arr[i]);
            }

            if(i - arr[i] >= 0 && i - arr[i] < n) {
                adj.get(i).add(i - arr[i]);
            }
        }

        boolean vis[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;

        while(!q.isEmpty()) {
            int curr = q.peek();
            q.remove();
            if(arr[curr] == 0) return true;

            for(int child : adj.get(curr)) {
                if(!vis[child]) {
                    vis[child] = true;
                    q.add(child);
                }
            }
        }
        return false;
    }
}