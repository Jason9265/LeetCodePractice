public class LeetCode36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int temp = 0;
                    for (int k = 0; k < 9; k++) {
                        if (board[i][k] == board[i][j]) {
                            temp++;
                        }
                    }
                    if (temp > 1) {
                        return false;
                    }
                    temp = 0;

                    for (int k = 0; k < 9; k++) {
                        if (board[k][j] == board[i][j]) {
                            temp++;
                        }
                    }
                    if (temp > 1) {
                        return false;
                    }
                    temp = 0;

                    // block
                    int a = (i / 3) * 3, b = (j / 3) * 3;
                    for (int c = 0; c < 3; c++) {
                        for (int d = 0; d < 3; d++) {
                            if (board[i][j] == board[a + c][b + d]) {
                                temp++;
                            }
                        }
                    }
                    if (temp > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
