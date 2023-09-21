class Solution {
    class DisjointSet {
        int par[];
        int size[];
        DisjointSet(int n) {
            par = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++) {
                par[i] = i;
                size[i] = 1;
            }
        }

        public int findUPar(int node) {
            if(node == par[node]) return node;
            return par[node] = findUPar(par[node]);
        }

        public void unionBySize(int a, int b) {
            int parA = findUPar(a);
            int parB = findUPar(b);
            if(parA == parB) return;
            if(size[parA] < size[parB]) {
                par[parA] = parB;
                size[parB] += size[parA];
            } 
            else {
                par[parB] = parA;
                size[parA] += size[parB];
            }
        }
    }

    public boolean isValid(int adjR, int adjC, int n, int m) {
        return adjR >= 0 && adjC >= 0 && adjR < n && adjC < m;
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        DisjointSet ds = new DisjointSet(n*m);
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                if(grid[row][col] == 0) continue;
                int dr[] = {-1, 0, 1, 0};
                int dc[] = {0, 1, 0, -1};

                for(int i = 0; i < 4; i++) {
                    int adjr = row + dr[i];
                    int adjc = col + dc[i];

                    if(isValid(adjr, adjc, n, m) && grid[adjr][adjc] == 1) {
                        int nodeNo = row * m + col;
                        int adjNo = adjr * m + adjc;
                        ds.unionBySize(nodeNo, adjNo);
                    }
                }
            }
        }

        int maxSize = 0;
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                if(grid[row][col] == 1) continue;
                int dr[] = {-1, 0, 1, 0};
                int dc[] = {0, 1, 0, -1};
                HashSet<Integer> set = new HashSet<>();
                for(int i = 0; i < 4; i++) {
                    int adjr = row + dr[i];
                    int adjc = col + dc[i];

                    if(isValid(adjr, adjc, n, m) && grid[adjr][adjc] == 1) {
                        set.add(ds.findUPar(adjr * m + adjc));
                    }
                }

                int tempSize = 0;
                for(int parent : set) {
                    tempSize += ds.size[parent];
                }
                maxSize = Math.max(maxSize, tempSize + 1);
            }
        }

        for(int cellNo = 0; cellNo < n * n; cellNo++) {
            maxSize = Math.max(maxSize, ds.size[ds.findUPar(cellNo)]);
        }
        return maxSize;
    }
}