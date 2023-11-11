class Graph {
    List<List<Pair>> adj;
    int V;
    class Pair {
        int first;
        int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    
    public Graph(int n, int[][] edges) {
        V = n;
        adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for(int row[] : edges) {
            adj.get(row[0]).add(new Pair(row[1], row[2]));
        }

    }
    
    public void addEdge(int[] edge) {
        adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
    }
    
    public int shortestPath(int node1, int node2) {
        int dist[] = new int[V];
        for(int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[node1] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.second, y.second));
        pq.add(new Pair(node1, 0));
        while(!pq.isEmpty()) {
            Pair it = pq.peek();
            pq.remove();
            int curr = it.first;
            int d = it.second;
            if(curr == node2) {
                return d;
            }
            for(Pair child : adj.get(curr)) {
                int ch = child.first;
                int dis = child.second;
                if(dist[ch] > dist[curr] + dis) {
                    dist[ch] = dist[curr] + dis;
                    pq.add(new Pair(ch, dist[ch]));
                }
            }
        }
        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */