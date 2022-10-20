public class LeetCode37 {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    boolean solve(char[][] board, int row, int col) {
        if (row == 9 && col == 8) return true;

        if (row == 9) {
            row = 0;
            col += 1;
        }

        if (board[row][col] != '.') return solve(board, row + 1, col);

        for (char i = '1'; i <= '9'; i++) {
            if (issafe(board, row, col, i)) {
                board[row][col] = i;
                if (solve(board, row + 1, col)) return true;
                board[row][col] = '.';
            }
        }
        return false;
    }

    boolean issafe(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) return false;
            if (board[row][i] == c) return false;
        }

        row = row - row % 3;
        col = col - col % 3;

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j] == c) return false;
            }
        }

        return true;
    }
}