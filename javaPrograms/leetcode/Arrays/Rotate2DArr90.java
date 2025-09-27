class Rotate2DArr90 {

    // public static int[][] solution(int[][]arr) {
    //     int n = arr.length;
    //     int[][]ans = new int[n][n];
    //     for(int i = 0; i < n; ++i) {
    //         for(int j = 0; j < n; ++j) {
    //             ans[j][n-1-i] = arr[i][j];
    //         }
    //     }
    //     return ans;
    // }

    public static int[][] solution(int[][]arr) {
        int i = 0, j = 0, temp = 0;
        for(i = 0; i < arr.length; ++i) {
            for(j = i; j < arr[0].length; ++j) {
                temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        for(i = 0; i < arr.length; ++i) {
            for(j = 0; j < arr.length/2; ++j) {
                temp = arr[i][j];
                arr[i][j] = arr[i][arr.length-1-j];
                arr[i][arr.length-1-j] = temp;
            }
        }
        return arr;
    }
    
    public static void main(String[]args) {
        int[][]arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("before-----------------");
        for(int i = 0; i < arr.length; ++i) {
            for(int j = 0; j < arr.length; ++j) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        arr = solution(arr);
        System.out.println("after------------------");
        for(int i = 0; i < arr.length; ++i) {
            for(int j = 0; j < arr.length; ++j) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
/*
00 01 02
1  2  3
4  5  6 
7  8  9

  |

7 4 1 0n
8 5 2 1n
9 6 3 2n
---------------------------------------------
Rotate Image by 90 degree

Problem Statement: Given a matrix, your task is to rotate the matrix 90 degrees clockwise.

Note: Rotate matrix 90 degrees anticlockwise

Examples
Brute Force Approach
Algorithm / Intuition
Approach: Take another dummy matrix of n*n, and then take the first row of the matrix and
put it in the last column of the dummy matrix, take the second row of the matrix,
and put it in the second last column of the matrix and so.

import java.util.*;
class Rotate2darr90 {
    static int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        int rotated[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - i - 1] = matrix[i][j];
            }
        }
        return rotated;
    }

    public static void main(String args[]) {
        int arr[][] =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int rotated[][] = rotate(arr);
        System.out.println("Rotated Image");
        for (int i = 0; i < rotated.length; i++) {
            for (int j = 0; j < rotated.length; j++) {
                System.out.print(rotated[i][j] + " ");
            }
            System.out.println();
        }

    }
}


Output:

Rotated Image
7 4 1
8 5 2
9 6 3

Complexity Analysis

Time Complexity: O(N*N) to linearly iterate and put it into some other matrix.

Space Complexity: O(N*N) to copy it into some other matrix.

Optimal Approach
Algorithm / Intuition
Intuition: By observation, we see that the first column of the original matrix is the
reverse of the first row of the rotated matrix, so that's why we transpose the matrix
and then reverse each row, and since we are making changes in the matrix itself space
complexity gets reduced to O(1).

Approach:

Step 1: Transpose the matrix. (transposing means changing columns to rows and rows to columns)

Step 2: Reverse each row of the matrix.

import java.util.*;
class Rotate2DArr90 {
    static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }

    public static void main(String args[]) {
        int arr[][] =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(arr);
        System.out.println("Rotated Image");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}


Output:

Rotated Image
7 4 1
8 5 2
9 6 3

Complexity Analysis

Time Complexity: O(N*N) + O(N*N).One O(N*N) is for transposing the matrix and the other
is for reversing the matrix.

Space Complexity: O(1).
---------------------------------------------
Transpose a Matrix : Program 0(1) space

Problem statement: Transpose a Matrix.

Given a matrix, your task is to find its transpose of the given matrix.

Transpose: The transpose of a matrix means, interchanging its rows into columns or columns into rows.

Examples:

Example 1:
Input:      {{4,5,6},
             {7,8,9},
             {10,11,12}}
Output: 
              4 7 10 
              5 8 11 
              6 9 12 

Explanation: The 1st row i.e 4,5,6 and 1st column i.e 4,7,10 
are interchanged in the same way other rows and columns 
will also interchange their values.

Example 2:
Input:   {{1,2,3}
          {4,5,6},
          {7,8,9},
          {10,11,12}}
Output:
        1 4 7 10 
        2 5 8 11 
        3 6 9 12 
Solution:
Disclaimer: Don't jump directly to the solution, try it out yourself first.

Solution 1: Brute force
Intuition:

By observing the question it is clear that the elements at 1st row are interchanged with 1st column,
and the elements at 2nd row are interchanged with the 2nd column and so on...
which means the element at index 0,1 is interchanging with the elements at the index 1,0 and
0,2 is interchanging with 2,0 and so on..., So to achieve this
we can use another matrix to store its corresponding values.

Approach:

Create a new matrix(say temp) to store new values.
Transverse through the entire matrix and while traversing interchange the rows and columns
Code:

public class TransposeOfMatrix {
    public static void main(String[] args) {

        // matrix initialization
        int matrix[][] =  { {4,5,6}, {7,8,9}, {10,11,12}};
        int m = matrix.length;
        int n = matrix[0].length;

        int temp[][] = transpose(matrix,m,n);

        // printing matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] transpose(int[][] matrix,int m,int n) {

        // creating new matrix to store transpose
        // Creating temp matrix of size [n][m] so 
        // that it will work for rectangle matrix also
        int temp[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = matrix[j][i];
            }
        }

        return temp;
    }
}
Output:

4 7 10
5 8 11
6 9 12

Time complexity: O(n*m) for traversing

Space complexity: O(n*m) for new matrix

Solution 2: In-place
Intuition:

From the definition of transpose it is known that transposing of a matrix is interchanging
the rows and columns, so to achieve this, we can directly interchange elements without using extra space.

Approach:

Traverse through the entire matrix
Swap row and corresponding column elements

public class TransposeOfMatrix {
    public static void main(String[] args) {

        //matrix initialization
        int matrix[][] =  { {4,5,6}, {7,8,9}, {10,11,12}};
        int m = matrix.length;
        int n = matrix[0].length;

      transpose(matrix,m,n);

        //printing matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void transpose(int[][] matrix,int m,int n) {

        for (int i=0;i<n;i++){
            for (int j=i+1;j<m;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
Output:

4 7 10
5 8 11
6 9 12

Time complexity: O(n*m) for traversing

Space complexity: O(1)
*/
