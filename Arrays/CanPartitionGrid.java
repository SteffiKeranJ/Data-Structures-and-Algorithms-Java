class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        long[] horSum = new long[m];
        long[] verSum = new long[n];
        
        long horTotal = 0;
        long verTotal = 0;
        for(int i = 0;i <m; ++i) {
            for(int j = 0; j < n; ++j) {
                horSum[i] += grid[i][j];
                horTotal += grid[i][j];
            }
        }
        
        for(int i = 0;i <n; ++i) {
            for(int j = 0; j < m; ++j) {
                verSum[i] += grid[j][i];
                verTotal += grid[j][i];
            }
        }
        
        long left = 0;
        int i= 0;
        while(left <= horTotal) {
            left += horSum[i];
            horTotal -= horSum[i];
            if(left == horTotal) return true;
            ++i;
        }
        left = 0;
        i= 0;
        while(left <= verTotal) {
            left += verSum[i];
            verTotal -= verSum[i];
            if(left == verTotal) return true;
            ++i;
        }
        
        return false;
        
    }
}
