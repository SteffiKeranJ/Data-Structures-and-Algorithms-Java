/**
1582. Special Positions in a Binary Matrix
https://leetcode.com/problems/special-positions-in-a-binary-matrix/description/

Given an m x n binary matrix mat, return the number of special positions in mat.

A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).

**/


class Solution {
    public int numSpecial(int[][] mat) {
        int res = 0;
        int n = mat.length, m = mat[0].length;
        int [] rowSum = new int[n], colSum = new int[m];

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                if(mat[i][j]==1) {
                    rowSum[i]++; colSum[j]++;
                }
            }
        }

        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j) {
                if(mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1)
                    res++;
            }
        }

        return res;
    }
}
