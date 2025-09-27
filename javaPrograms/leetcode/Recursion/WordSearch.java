/**
   79. Word Search

   Given an m x n grid of characters board and a string word, return true if word exists
   in the grid.

   The word can be constructed from letters of sequentially adjacent cells, where adjacent
   cells are horizontally or vertically neighboring. The same letter cell may not be used
   more than once.

   Example 1:
   Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
   Output: true

   Example 2:
   Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
   Output: true

   Example 3:
   Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
   Output: false
 
   Constraints:

   m == board.length
   n = board[i].length
   1 <= m, n <= 6
   1 <= word.length <= 15
   board and word consists of only lowercase and uppercase English letters.
   
   # Solution:

   Approach:  We are going to solve this by using backtracking, in this approach first we will
   linearly search the entire matrix to find the first letters matching our given string. If we
   found those letters then we can start backtracking in all four directions to find the rest of
   the letters of the given string.

   Step 1: Find the first character of the given string.

   Step 2: Start Backtracking in all four directions until we find all the letters of sequentially
   adjacent cells.

   Step 3: At the end, If we found our result then return true else return false.

   Edge cases: Now think about what will be our stopping condition, we can stop or return false if
   we reach the end of the boundaries of the matrix or the letter at which we are making recursive
   calls is not the required letter.

   We will also return if we found all the letters of the given word i.e. we found the number of
   letters equal to the length of the given word.

   NOTE: Do not forget that we cannot reuse a cell again.

   That is, we have to somehow keep track of our position so that we cannot find the same letter
   again and again.

   In this approach, we are going to mark visited cells with some random character that will prevent
   us from revisiting them again and again.
*/
class WordSearch {
    public static boolean search(char[][]board, String word, int m, int n, int row, int col, int index) {
        if(index == word.length()) return true;
        if(row < 0 || col < 0 || row == m || col == n || board[row][col] != word.charAt(index) || board[row][col] == '0')
            return false;
        char c = board[row][col];
        board[row][col] = '0'; log.info("c="+c);
        log.info((Object[])board);
        boolean top = search(board, word, m, n, row-1, col, index+1); log.info("top="+top);
        boolean bot = search(board, word, m, n, row+1, col, index+1); log.info("bot="+bot);
        boolean rit = search(board, word, m, n, row, col+1, index+1); log.info("rit="+rit);
        boolean lef = search(board, word, m, n, row, col-1, index+1); log.info("lef="+lef);
        board[row][col] = c;
        return top || bot || rit || lef;
    }
    public static boolean exist(char[][]board, String word) {
        int m = board.length;
        int n = board[0].length;
        int index = 0;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(board[i][j] == word.charAt(index)) {
                    if(search(board, word, m, n, i, j, index)) return true;
                }
            }
        }
        return false;
    }
    public static void main(String[]args) {
        // char[][]board = {{'A','B','C','E'},
        //                  {'S','F','C','S'},
        //                  {'A','D','E','E'}};
        // String word = "ABCCED";

        char[][]board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";

        // char[][]board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        // String word = "ABCB";
        
        log.info(exist(board, word));
    }
    private static final Log log = new Log();
}
/**
class WordSearch {
        public static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        if (word.length() == 0) return true;

        // 1) Count frequencies on board
        int[] cnt = new int[128];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cnt[board[i][j]]++;
                //log.info(cnt[board[i][j]]++);
            }
        }

        //log.info("cnt");
        //log.info(cnt);

        // 2) Check feasibility and decide direction
        int[] need = new int[128];
        for (int k = 0; k < word.length(); k++) need[word.charAt(k)]++;

        //log.info("need");
        //log.info(need);

        for (int ch = 0; ch < 128; ch++) {
            //if(need[ch] != 0 || cnt[ch] != 0) log.info("need[ch]---cnt[ch]"+need[ch]+" "+cnt[ch]);
            if (need[ch] > 0 && need[ch] > cnt[ch]) {
                return false;
            }
        }

        // Rarity heuristic: start from less frequent end
        char first = word.charAt(0), last = word.charAt(word.length() - 1);

        //log.info("cnt[first] --- cnt[last] = "+cnt[first]+"---"+cnt[last]);

        if (cnt[first] > cnt[last]) {
            word = new StringBuilder(word).reverse().toString();
        }

        // 3) Backtracking
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }
    private static boolean dfs(char[][] b, String w, int k, int r, int c) {
        if (k == w.length()) return true;
        if (r < 0 || c < 0 || r >= b.length || c >= b[0].length) return false;
        if (b[r][c] != w.charAt(k)) return false;

        char saved = b[r][c];
        b[r][c] = '\0'; // mark visited

        // Try four directions
        if (dfs(b, w, k + 1, r + 1, c) ||
            dfs(b, w, k + 1, r - 1, c) ||
            dfs(b, w, k + 1, r, c + 1) ||
            dfs(b, w, k + 1, r, c - 1)) {
            b[r][c] = saved;
            return true;
        }

        b[r][c] = saved; // restore
        return false;
    }
}
 */
