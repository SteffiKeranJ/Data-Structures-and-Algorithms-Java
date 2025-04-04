class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n+2][m+2];
        for(int i = 0; i < m; ++i) dp[0][i] = matrix[0][i];

        int result = Integer.MAX_VALUE;
        for(int i = 1; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                if(j == 0) dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j+1]) + matrix[i][j];
                else if (j == n-1) dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + matrix[i][j];
                else dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j+1], dp[i-1][j-1])) + matrix[i][j];
            }
        }
        for(int i = 0; i < m; ++i) {
            result = Math.min(result, dp[n-1][i]);
        }
        return result;

    }
}
