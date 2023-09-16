class Solution {
    class Tuple {
        int first;
        int second;
        int third;
        Tuple(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    public boolean isValid(int row, int col, int n, int m) {
        return row >= 0 && col >= 0 && row < n && col < m;
    }

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int dist[][] = new int[n][m];
        for(int row[] : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.third, y.third));
        pq.add(new Tuple(0, 0, 0));
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};

        while(!pq.isEmpty()) {
            Tuple it = pq.peek();
            pq.remove();
            int row = it.first;
            int col = it.second;
            int effort = it.third;

            if(row == n-1 && col == m-1) return effort;

            for(int i = 0; i < 4; i++) {
                int nRow = row + dr[i];
                int nCol = col + dc[i];
                
                if(isValid(nRow, nCol, n, m)) {
                    int maxEffort = Math.max(effort, Math.abs(heights[row][col] - heights[nRow][nCol]));
                    if(maxEffort < dist[nRow][nCol]) {
                        dist[nRow][nCol] = maxEffort;
                        pq.add(new Tuple(nRow, nCol, maxEffort));
                    }
                }
            }
        }
        return 0;
    }
}