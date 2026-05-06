/**
   1861. Rotating the Box

   You are given an m x n matrix of characters boxGrid representing a side-view of a box.
   Each cell of the box is one of the following:

   A stone '#'
   A stationary obstacle '*'
   Empty '.'
   The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity.
   Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box.
   Gravity does not affect the obstacles' positions, and the inertia from the box's rotation
   does not affect the stones' horizontal positions.

   It is guaranteed that each stone in boxGrid rests on an obstacle, another stone, or the
   bottom of the box.

   Return an n x m matrix representing the box after the rotation described above.

   Example 1:
   Input: boxGrid = [["#",".","#"]]
   Output: [["."],
   ["#"],
   ["#"]]

   Example 2:
   Input: boxGrid = [["#",".","*","."],
   ["#","#","*","."]]
   Output: [["#","."],
   ["#","#"],
   ["*","*"],
   [".","."]]

   Example 3:
   Input: boxGrid = [["#","#","*",".","*","."],
   ["#","#","#","*",".","."],
   ["#","#","#",".","#","."]]
   Output: [[".","#","#"],
   [".","#","#"],
   ["#","#","*"],
   ["#","*","."],
   ["#",".","*"],
   ["#",".","."]]

   Constraints:
   m == boxGrid.length
   n == boxGrid[i].length
   1 <= m, n <= 500
   boxGrid[i][j] is either '#', '*', or '.'.
*/
class RotatingTheBox {
    /**
       Approach: Combine rotation and gravity operations
       Intuition
       streamline the code by combining the operations of rotation and the effects of gravity.
       This will allow us to generate the result in a single pass instead of three, potentially
       reducing the runtime of our program.

       First, let's derive the formula to find the position of the cell originally located at
       (i,j) in the rotated grid. Following the strategy outlined for the transpose grid, we
       will first map the position (i,j) to (j,i). Then, we will reverse each row, meaning that
       the first element becomes the last, the second element becomes the second-to-last, and
       so on. Specifically, the element at index i will move to the position m - i - 1. Combining
       these two conversions, we get that the cell originally located at (i,j) will end up in
       the position (j,m - i - 1).

       Now, we are ready to execute the same algorithm as before. This time, we will read the
       type of each cell from the original grid, box, and place the results into the result grid
       using the positions determined by the formula outlined above.

       Algorithm
       Initialize m and n to the number of rows and columns of the original grid, respectively.
       Create an n x m grid, called result, and initialize all of its elements to be empty
       cells ('.').
       Iterate over the rows of the original grid, box, with i from 0 to m - 1:
       For each row i, initialize a variable lowestRowWithEmptyCell to n - 1.
       Iterate over all of its elements in reversed order with j from n - 1 to 0. On each iteration:
       If box[i][j] contains a stone, let it fall to the lowest empty cell:
       Set result[lowestRowWithEmptyCell][m - i - 1] = '#'.
       (Optionally) Set result[j][m - i - 1] = '.'.
       Update lowestRowWithEmptyCell to i - 1.
       If box[i][j] contains an obstacle:
       Set result[j][m - i - 1] = '*'.
       Update lowestRowWithEmptyCell to i - 1.
       Return result.
       Implementation

       Complexity Analysis
       Time complexity: O(m*n)

       The rotation of the grid and the gravity effect are implemented using two nested loops.
       The outer loop iterates over the m rows of the original grid, and for each row, the inner
       loop processes all n elements. Therefore, the total time complexity of the algorithm is O(m*n).

       Space complexity: O(m*n)

       Similar to the other two approaches, we prefer not to modify the input, by creating a new n*m grid.
     */
    private static char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length, m = boxGrid[0].length;
        char[][] arr = new char[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                arr[i][j] = '.';
            }
        }

        for (int i = 0; i < n; ++i) {
            int lowestEmptyCell = m - 1;
            for (int j = m - 1; j >= 0; --j) {
                if (boxGrid[i][j] == '#') {
                    arr[lowestEmptyCell][n - i - 1] = '#';
                    lowestEmptyCell--;
                }
                if (boxGrid[i][j] == '*') {
                    arr[j][n - i - 1] = '*';
                    lowestEmptyCell = j - 1;
                }
            }
        }
        return arr;
    }
    private static void printCharArray(char[][] arr) {
        for (char[] ch : arr) Log.info(ch);
        Log.info("------------------------------------------");
    }
    public static void main(String[] args) {
        printCharArray(rotateTheBox(new char[][] {{'#','.','#'}}));

        printCharArray(rotateTheBox(new char[][] {{'#','.','*','.'},
                                                  {'#','#','*','.'}}));

        printCharArray(rotateTheBox(new char[][] {{'#','#','*','.','*','.'},
                                                  {'#','#','#','*','.','.'},
                                                  {'#','#','#','.','#','.'}}));
    }
}
/**
    // ulta loop chalao
    // agarar # ke immidiate right me . ho to unko swap kardo
    // naya char[][] banana hai ?
    private static char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length, m = boxGrid[0].length;
        char[][] arr = new char[m][n];

        printCharArray(boxGrid);
        for (char[] ch : boxGrid) {
            for (int i = ch.length - 1; i >= 0; --i) {
                boolean didSwap = false;
                for (int j = 0; j <= i - 1; ++j) {
                    if (ch[j] == '#' && ch[j + 1] == '.') {
                        char tmp = ch[j];
                        ch[j] = ch[j + 1];
                        ch[j + 1] = tmp;
                        didSwap = true;
                    }
                }
                if (!didSwap) break;
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0, k = n - 1; j < n; ++j, --k) {
                arr[i][j] = boxGrid[k][i];
                    }
        }

        printCharArray(boxGrid);

        return arr;
    }
*/
/**
(0,0) (0,1) (0,2) (0,3) (0,4) (0,5)
[#,    #,    *,    .,    *,    .]

(1,0) (1,1) (1,2) (1,3) (1,4) (1,5)
[#,    #,    #,    *,    .,    .]

(2,0) (2,1) (2,2) (2,3) (2,4) (2,5)
[.,    .,    #,    #,    #,    #]


------------------------------------------


(0,0) (0,1) (0,2)
[.,    #,    #]

(1,0) (1,1) (1,2)
[.,    #,    #]

(2,0) (2,1) (2,2)
[#,    #,    *]

(3,0) (3,1) (3,2)
[#,    *,    .]

(4,0) (4,1) (4,2)
[#,    .,    *]

(5,0) (5,1) (5,2)
[#,    .,    .]



arr    | boxgrid
(0,0)  | (2,0)
(0,1)  | (1,0)
(0,2)  | (0,0)



for (int i = 0; i < m; ++i) {
    for (int j = 0, k = n - 1; j < n; ++j, --k) {
         arr[i][j] = boxgrid[k][i]
    }
}
*/
