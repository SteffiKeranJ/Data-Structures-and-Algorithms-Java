class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int n = prerequisites.length;

        int[] ingress = new int[numCourses];
        List<Integer>[] al = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; ++i) al[i] = new ArrayList<>();

        for(int[] pre: prerequisites) {
            int first = pre[0];
            int sec = pre[1];
            ingress[first]++;
            al[sec].add(first);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < numCourses; ++i) {
            if(ingress[i] == 0) pq.offer(i);
        }
        int counter = 0;
        while(!pq.isEmpty()) {
            int u = pq.poll();
            result[counter++] = u;

            for(int v: al[u]) {
                ingress[v]--;
                if(ingress[v] == 0) pq.offer(v);
            }
        }

        if(counter!=numCourses) return new int[]{};

        return result;

    }
}
