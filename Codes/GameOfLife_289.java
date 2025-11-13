package classic150;

public class GameOfLife_289 {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;

        int[][] copy = new int[m + 2][n + 2];
        for (int i = 1; i <= m; i++) {
            System.arraycopy(board[i - 1], 0, copy[i], 1, n);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = count(copy, i + 1, j + 1);
                int cell = copy[i + 1][j + 1];

                if (cell == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = 0; // 死亡
                } else if (cell == 1 && (liveNeighbors == 2 || liveNeighbors == 3)) {
                    board[i][j] = 1; // 继续存活
                } else if (cell == 0 && liveNeighbors == 3) {
                    board[i][j] = 1; // 复活
                } else {
                    board[i][j] = 0; // 其他情况保持死亡
                }
            }
        }
    }

    private int count(int[][] board, int i, int j) {
        return board[i - 1][j - 1] + board[i - 1][j] + board[i - 1][j + 1]
                + board[i][j - 1]                     + board[i][j + 1]
                + board[i + 1][j - 1] + board[i + 1][j] + board[i + 1][j + 1];
    }
}


/*

 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；

 */