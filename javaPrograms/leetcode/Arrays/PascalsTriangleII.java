/*
  119. Pascal's Triangle II

  Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

  In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

  Example 1:
  Input: rowIndex = 3
  Output: [1,3,3,1]

  Example 2:
  Input: rowIndex = 0
  Output: [1]

  Example 3:
  Input: rowIndex = 1
  Output: [1,1]

  Constraints:
  0 <= rowIndex <= 33
 */
import java.util.List;
import java.util.ArrayList;
class PascalsTriangleII {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long ans = 1;
        int n = rowIndex+1;
        row.add(1);
        for(int i = 1; i < n; ++i) {
            ans *= (n-i);
            ans /= i;
            row.add((int) ans);
        }
        return row;
    }
    public static void main(String[]args) {
        log.info(getRow(3)); // [1, 3, 3, 1]
        log.info(getRow(0)); // [1]
        log.info(getRow(1)); // [1, 1]
    }
    private static final Log log = new Log();
}
/**
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for(int i = 0; i < rowIndex; ++i) {
            List<Integer> tempRow = new ArrayList<>();
            tempRow.add(1);
            for(int j = 1; j < row.size(); ++j)
                tempRow.add(row.get(j-1) + row.get(j));
            tempRow.add(1);
            row = tempRow;
        }
        return row;
    }

 */
