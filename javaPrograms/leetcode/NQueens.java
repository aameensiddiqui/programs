/**
   51. N-Queens

   The n-queens puzzle is the problem of placing n queens on an n x n chessboard
   such that no two queens attack each other.

   Given an integer n, return all distinct solutions to the n-queens puzzle.
   You may return the answer in any order.

   Each solution contains a distinct board configuration of the n-queens' placement,
   where 'Q' and '.' both indicate a queen and an empty space, respectively.

   Example 1:
   Input: n = 4
   Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
   Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

   Example 2:
   Input: n = 1
   Output: [["Q"]]
 
   Constraints:
   1 <= n <= 9
 */
import java.util.*;
class NQueens {
    public static List<String> constructList(char[][]board) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < board.length; ++i) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
    public static void backtrack(char[][]board, List<List<String>> list, int col,
                                 int[]leftRow, int[]upperDiagonal, int[]lowerDiagonal) {
        int len = board.length;
        if(col == len) {
            list.add(constructList(board));
            return;          
        }
        for(int row = 0; row < len; ++row) {
            if(leftRow[row] == 0 && upperDiagonal[row+col] == 0 && lowerDiagonal[len-1+col-row] == 0) {

                board[row][col] = 'Q';

                leftRow[row] = 1;
                upperDiagonal[row+col] = 1;
                lowerDiagonal[len-1+col-row] = 1;

                backtrack(board, list, col+1, leftRow, upperDiagonal, lowerDiagonal);
                
                board[row][col] = '.';

                leftRow[row] = 0;
                upperDiagonal[row+col] = 0;
                lowerDiagonal[len-1+col-row] = 0;
            }
        }
    }
    public static List<List<String>> solveQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        char[][]board = new char[n][n];
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < n; ++j)
                board[i][j] = '.';
        
        int[]leftRow       = new int[n];
        int[]upperDiagonal = new int[2*n-1];
        int[]lowerDiagonal = new int[2*n-1];
        backtrack(board, list, 0, leftRow, upperDiagonal, lowerDiagonal);
        return list;
    }
    public static void main(String[]args) {
        log.info(solveQueens(4));
    }
    private static final Log log = new Log();
}
/**
    public static boolean validate(char[][]board, int row, int col) {
        int trow = row;
        int tcol = col;
        while(row >= 0 && col >= 0) {
            if(board[row][col] == 'Q') return false;
            row--; col--;
        }
        row = trow;
        col = tcol;
        while(col >= 0) {
            if(board[row][col] == 'Q') return false;
            col--;
        }
        row = trow;
        col = tcol;
        while(col >= 0 && row < board.length) {
            if(board[row][col] == 'Q') return false;
            col--; row++;
        }
        return true;
    }
    public static List<String> constructList(char[][]board) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < board.length; ++i) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
    public static void backtrack(char[][]board, List<List<String>> list, int col) {
        if(col == board.length) {
            list.add(constructList(board));
            return;
        }
        for(int row = 0; row < board.length; ++row) {
            if(validate(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(board, list, col+1);
                board[row][col] = '.';
            }
        }
    }
 */
