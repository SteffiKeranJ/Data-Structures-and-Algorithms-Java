class Solution {
    int[] p;
    public int findCircleNum(int[][] isConnected) {
        int result = 0;
        int n = isConnected.length;
        p = new int[n+1];
        
        for(int i = 0;i < n; ++i) p[i] = i;

        for(int i = 0; i < n; ++i) {
            for(int j =0; j <n;++j) {
                if(isConnected[i][j] == 1) union(i, j);
            }
        }
        for(int i = 0; i < n; ++i) {
            if(p[i] == i) result++;
        }

        return result;
    }

    private void union(int a, int b) {
        int pA = find(a);
        int pB = find(b);

        if(pA <= pB) {
            p[pA] = pA;
            p[pB] = pA;
        } else {
            p[pA] = pB;
            p[pB] = pB;
        }
    }


    int find(int x) {
        if(p[x] == x) return x;
        return p[x] = find(p[x]);
    }
}
