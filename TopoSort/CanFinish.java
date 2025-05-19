class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] ingress = new int[numCourses];
        List<Integer>[] al= new ArrayList[numCourses];
        for(int i = 0; i < numCourses; ++i) al[i] = new ArrayList<>();
        int counter = 0;
        int n = prerequisites.length;

        for(int i = 0; i < n; ++i) {
            int first = prerequisites[i][0];
            int sec = prerequisites[i][1];

            ingress[first]++;
            al[sec].add(first);
        }

        Queue<Integer> pq = new LinkedList<>();

        for(int i = 0; i < numCourses; ++i) {
            if(ingress[i] == 0) pq.offer(i);
        }
       
        while(!pq.isEmpty()) {
            int u = pq.poll();
            counter++;
            for(int v : al[u]) {
                
                ingress[v]--;
                if(ingress[v] == 0) pq.offer(v);
            }
        }
        
        return counter == numCourses;
    }
}
