import java.util.*;
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        solve(0, n, new int[n], result);
        return result;
    }
    void solve(int row, int n, int[] queens, List<List<String>> result) {
        if (row == n) {
            List<String> board = new ArrayList<>();
            for (int i : queens) {
                char[] rowArray = new char[n];
                Arrays.fill(rowArray, '.');
                rowArray[i] = 'Q';
                board.add(new String(rowArray));
            }
            result.add(board);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, queens)) {
                queens[row] = col;
                solve(row + 1, n, queens, result);
            }
        }
    }
    boolean isValid(int row, int col, int[] queens) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(queens[i] - col) == row - i)
                return false;
        }
        return true;
    }
}