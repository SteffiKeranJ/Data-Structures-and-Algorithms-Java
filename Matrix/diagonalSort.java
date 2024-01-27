/**
A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column and going in the bottom-right direction until reaching the matrix's end. For example, the matrix diagonal starting from mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].

Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.
**/

class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        List<Integer> list = new ArrayList<>();

        if(m == 1) return mat; // nothing to sort

        int i = m-2; // start with 2nd row;
        int j = 0;

        while(i != 0 || j != n-1) {
            list.clear();
            int x = i, y = j;
            while(x < m && y < n) {
                list.add(mat[x++][y++]);
            }
            Collections.sort(list);
            x = i; y = j;
            for(Integer item : list) {
                mat[x++][y++] = item;
            }

            if(i!=0) i--;
            else j++;
        }
        return mat;
    }
}
