/**
Given a 0-indexed m x n integer matrix matrix, create a new 0-indexed matrix called answer. Make answer equal to matrix, then replace each element with the value -1 with the maximum element in its respective column.

Return the matrix answer.

Example 1:

Input: matrix = [[1,2,-1],[4,-1,6],[7,8,9]]
Output: [[1,2,9],[4,8,6],[7,8,9]]
Explanation: The diagram above shows the elements that are changed (in blue).
- We replace the value in the cell [1][1] with the maximum value in the column 1, that is 8.
- We replace the value in the cell [0][2] with the maximum value in the column 2, that is 9.

Example 2:

Input: matrix = [[3,-1],[5,2]]
Output: [[3,2],[5,2]]
Explanation: The diagram above shows the elements that are changed (in blue).

**/

class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        Map<Integer, Integer> maxElementMap = new HashMap<>();
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i < m; ++i) {
            int maxEl = -1;
            for(int j = 0; j < n; ++j) {
                maxEl = Math.max(maxEl, matrix[j][i]);
            }
            maxElementMap.put(i, maxEl);
        }

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                if(matrix[i][j] != -1) continue;
                matrix[i][j] = maxElementMap.getOrDefault(j, -1);
            }
        }
        return matrix;
    }
}
