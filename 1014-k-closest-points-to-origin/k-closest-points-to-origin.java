class Solution {
    class Tuple {
        int x;
        int y;
        int dist;
        Tuple(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.dist, y.dist));
        for(int row[] : points) {
            pq.add(new Tuple(row[0], row[1], row[0]*row[0] + row[1]*row[1]));
        }
        int ans[][] = new int[k][2];
        for(int i = 0; i < k; i++) {
            Tuple it = pq.peek();
            pq.remove();
            int arr[] = new int[]{it.x, it.y};
            ans[i] = arr;
        }
        return ans;
    }
}