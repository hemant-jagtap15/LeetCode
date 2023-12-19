class Solution {
    public int[][] imageSmoother(int[][] img) {
        int rows = img.length;
        int cols = img[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = smoothPixel(img, i, j, rows, cols);
            }
        }

        return result;
    }

    private int smoothPixel(int[][] img, int row, int col, int rows, int cols) {
        int sum = 0;
        int count = 0;

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (isValidPixel(i, j, rows, cols)) {
                    sum += img[i][j];
                    count++;
                }
            }
        }

        return sum / count;
    }

    private boolean isValidPixel(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}