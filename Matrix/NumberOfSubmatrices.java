class Solution {
    int n, m;
    private int[][] computeBlockSum(char c, char[][]grid) {
        int[][] countArray = new int[n+1][m+1];
        Arrays.stream(countArray).forEach(a -> Arrays.fill(a, 0));

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                countArray[i][j] = (grid[i][j] == c) ? 1 : 0;
                if(i > 0) countArray[i][j]+= countArray[i-1][j];
                if(j > 0) countArray[i][j]+= countArray[i][j-1];
                if(i > 0 && j > 0) countArray[i][j] -= countArray[i-1][j-1];

            }
        }

        return countArray;
    }

    public int numberOfSubmatrices(char[][] grid) {
        n = grid.length;
        m = grid[0].length;

        int[][] xCount = computeBlockSum('X', grid);
        int[][] yCount = computeBlockSum('Y', grid);

        int ans = 0;

        for(int i = 0; i < n; ++i) {
            for (int j = 0; j < m; j++) {
                ans += ((xCount[i][j] == yCount[i][j]) && (xCount[i][j] > 0)) ? 1: 0;
            }
        }
        return ans;
    }
}
