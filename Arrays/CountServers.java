class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] rowComputers = new int[m];
        int[] colComputers = new int[n];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(grid[i][j] == 1) {
                    rowComputers[i]++;
                    colComputers[j]++;
                }
            }
        }
        int connComputers = 0;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(grid[i][j] == 1) {
                    if(rowComputers[i] > 1 || colComputers[j] > 1) connComputers++;
                }
            }
        }
        return connComputers;
    }
}
