/*
You are given an m x n integer array grid where grid[i][j] could be:

    1 representing the starting square. There is exactly one starting square.
    2 representing the ending square. There is exactly one ending square.
    0 representing empty squares we can walk over.
    -1 representing obstacles that we cannot walk over.

Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

 

Example 1:

Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

Example 2:

Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)

Example 3:

Input: grid = [[0,1],[2,0]]
Output: 0
Explanation: There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.

*/

class Solution {
    int result;

    private void dfs(int[][] grid, int i, int j, int m, int n, int toVisit) {
        
        if(i < 0 || i >= m || j < 0 || j >= n) return;

        if(grid[i][j] == -1 || grid[i][j] == -2) return;

        toVisit -= 1;

        if(grid[i][j] == 2 && toVisit == 0) {
            result++;
            return;
        }
        int temp = grid[i][j];
        grid[i][j] = -2;

        dfs(grid, i-1, j, m, n, toVisit);
        dfs(grid, i+1, j, m, n, toVisit);
        dfs(grid, i, j-1, m, n, toVisit);
        dfs(grid, i, j+1, m, n, toVisit);

        grid[i][j] = temp;

    }


    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        result = 0;
        int counter = 0;

        for(int i = 0;i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(grid[i][j] == 0) counter++;
            }
        }

        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(grid[i][j] == 1) {
                    dfs(grid, i, j, m, n, counter+2);
                    break;
                }
            }
        }

        return result;
    }
}
