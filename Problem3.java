import java.util.*;

class Problem3 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];

        int[] rowDir = {0, 1, 0, -1};
        int[] colDir = {1, 0, -1, 0};

        int row = 0, col = 0, dir = 0;

        for (int i = 0; i < m * n; i++) {
            result.add(matrix[row][col]);
            visited[row][col] = true;

            int nextRow = row + rowDir[dir];
            int nextCol = col + colDir[dir];

            if (nextRow>=0 && nextRow<m && nextCol>=0 && nextCol<n && !visited[nextRow][nextCol]) {
                row = nextRow;
                col = nextCol;
            } else {
                dir = (dir+1)%4;
                row += rowDir[dir];
                col += colDir[dir];
            }
        }
        return result;
    }
}