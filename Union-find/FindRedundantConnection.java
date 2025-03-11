/*
In this problem, a tree is an undirected graph that is connected and has no cycles.

You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.

 

Example 1:

Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]

Example 2:

Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
Output: [1,4]

*/
class Solution {
    int[] p = new int[1001];
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] res = new int[2];
        for(int i = 0; i <=n; ++i) p[i] = i;
        for(int i = 0; i < n; ++i) {
            int x = findParent(edges[i][0]);
            int y = findParent(edges[i][1]);
            if(x != y) p[y]=x; // form an edge
            else { // redundant edge identified
                res[0] = edges[i][0];
                res[1] = edges[i][1];
            }
        }
        return res;
    }

    private int findParent(int x) {
        return p[x] == x ? x: findParent(p[x]);
    }
}
