class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int prev[] = new int[m];
        int ans = 0;

        for(int i = 0; i < n; i++) {
            int curr[] = matrix[i].clone();
            for(int j = 0; j < m; j++) {
                if(curr[j] != 0) {
                    curr[j] += prev[j];
                } 
            }
            int temp[] = curr.clone();
            Arrays.sort(temp);
            for(int k = 0; k < m; k++) {
                ans = Math.max(ans, temp[k] * (m - k));
            }
            prev = curr;
        }
        return ans;
    }
}