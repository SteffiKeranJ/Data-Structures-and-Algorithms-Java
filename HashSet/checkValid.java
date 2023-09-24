/**
An n x n matrix is valid if every row and every column contains all the integers from 1 to n (inclusive).

Given an n x n integer matrix matrix, return true if the matrix is valid. Otherwise, return false.

 

Example 1:

Input: matrix = [[1,2,3],[3,1,2],[2,3,1]]
Output: true
Explanation: In this case, n = 3, and every row and column contains the numbers 1, 2, and 3.
Hence, we return true.

Example 2:

Input: matrix = [[1,1,1],[1,2,3],[1,2,3]]
Output: false
Explanation: In this case, n = 3, but the first row and the first column do not contain the numbers 2 or 3.
Hence, we return false.

 

Constraints:

    n == matrix.length == matrix[i].length
    1 <= n <= 100
    1 <= matrix[i][j] <= n



**/
class Solution {
    public boolean checkValid(int[][] matrix) {
        HashSet<Integer> uniqueSet = new HashSet<>();

        int n = matrix[0].length;
        // since constraints already mention that the
        // value of the matrix will <= n, we can skip the condition
        // to check if the value of matrix crosses the 1 <=matrix[i][]j<=n range

        int i, j;

        for(i = 0; i < n; ++i) {
            uniqueSet.clear();
            for(j = 0; j < n; ++j) {
                uniqueSet.add(matrix[i][j]);
            }
            if(uniqueSet.size() != n){
                return false;
            }
        }
       
        for(i = 0; i < n; ++i) {
            uniqueSet.clear();
            for(j = 0; j < n; ++j) {
                uniqueSet.add(matrix[j][i]);
            }
            if(uniqueSet.size() != n){
                return false;
            }
        }

        return true;
    }
}
