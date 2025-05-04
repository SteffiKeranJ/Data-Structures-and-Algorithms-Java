class Solution {
    boolean[] visited;
    private void dfs(List<List<Integer>> rooms, boolean[] visited, int u) {
            List<Integer> adj = rooms.get(u);
            visited[u] = true;
            for(int key: adj) {
                if(!visited[key]) {
                    dfs(rooms, visited,key);
                }
            }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        visited = new boolean[n];

        dfs(rooms, visited, 0);

        for(boolean v: visited) {
            if(!v) return false;
        }

        return true;
    }
}
