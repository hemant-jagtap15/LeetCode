class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans[][] = new int[n][m];
        int onesRow[] = new int[n];
        int onesCol[] = new int[m];
        int zerosRow[] = new int[n];
        int zerosCol[] = new int[m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 0) {
                    zerosRow[i]++;
                    zerosCol[j]++;
                } else {
                    onesRow[i]++;
                    onesCol[j]++;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ans[i][j] = onesRow[i] + onesCol[j] - zerosRow[i] - zerosCol[j];
            }
        }
        return ans;
    }
}