class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(List<Integer> pair : pairs) {
            int u = pair.get(0);
            int v = pair.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        char ans[] = new char[n];

        boolean vis[] = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                ArrayList<Character> ch = new ArrayList<>();
                ArrayList<Integer> idxs = new ArrayList<>();
                bsf(adj, i, vis, s, ch, idxs);

                Collections.sort(ch);
                Collections.sort(idxs);

                for(int j = 0; j < ch.size(); j++) {
                    ans[idxs.get(j)] = ch.get(j);
                }
            }
        }

        return new String(ans);
    }

    public void bsf(List<List<Integer>> adj, int n, boolean vis[], String s, ArrayList<Character> ch, ArrayList<Integer> idxs) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        vis[n] = true;

        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            ch.add(s.charAt(node));
            idxs.add(node);
            for(int child : adj.get(node)) {
                if(!vis[child]) {
                    vis[child] = true;
                    q.add(child);
                }
            }
        }
    }
}