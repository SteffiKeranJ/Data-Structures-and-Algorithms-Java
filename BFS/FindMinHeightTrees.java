/*
310. Minimum Height Trees

A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.

Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).

Return a list of all MHTs' root labels. You can return the answer in any order.

The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
*/

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++){
            adjList[i] = new ArrayList<>();
        }
        if(edges.length == 0) return List.of(0);
        for(int[] edge: edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (adjList[i].size() == 1){
                q.offer(i);
            }
        }


        int remainingNodes = n;
        while(remainingNodes > 2) {
            int l = q.size();
            remainingNodes-=l;
            while(l > 0){
                int node = q.poll();
                int neighbor = adjList[node].get(0);
                adjList[neighbor].remove(Integer.valueOf(node));
                if(adjList[neighbor].size() == 1) q.add(neighbor);
                l--;
            }
        }

        return new ArrayList<>(q);
    }
}
