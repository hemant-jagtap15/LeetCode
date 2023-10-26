class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == word.charAt(0)) {
                    boolean vis[][] = new boolean[n][m];
                    if(dfs(0, i, j, word, board, vis)) return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int i, int row, int col, String word, char board[][], boolean vis[][]) {
        vis[row][col] = true;
        if(i == word.length() - 1) return true;
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};

        for(int j = 0; j < 4; j++) {
            int nrow = row + dr[j];
            int ncol = col + dc[j];
            if(isValid(nrow, ncol, board.length, board[0].length) && !vis[nrow][ncol] && board[nrow][ncol] == word.charAt(i+1)) {
                if (dfs(i + 1, nrow, ncol, word, board, vis)) {
                    return true;
                }
            }
        }
        vis[row][col] = false;
        return false;
    }

    public boolean isValid(int row, int col, int n, int m) {
        return row >= 0 && col >= 0 && row < n && col < m;
    }
}