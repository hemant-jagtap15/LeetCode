class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0;
        int high = m-1;

        while(low <= high) {
            int mid = (low + high) / 2;
            int maxRowIdx = findMaxIdx(mat, n, m, mid);
            int left = mid - 1 >= 0 ? mat[maxRowIdx][mid-1] : -1;
            int right = mid + 1 < m ? mat[maxRowIdx][mid + 1] : -1;
            if(left < mat[maxRowIdx][mid] && mat[maxRowIdx][mid] > right) {
                return new int[]{maxRowIdx, mid};
            }
            if(mat[maxRowIdx][mid] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public int findMaxIdx(int mat[][], int n, int m, int col) {
        int maxValue = -1;
        int idx = -1;
        for(int i = 0; i < n; i++) {
            if(mat[i][col] > maxValue) {
                maxValue = mat[i][col];
                idx = i;
            }
        }
        return idx;
    }
}