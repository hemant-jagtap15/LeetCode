class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat[0].length;
        for(int row[] : mat) {
            for(int i = 0; i < m; i++) {
                if(row[i] != row[(i+k) % m]) return false;
            }
        }
        return true;
    }
}