class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());
 int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) {
            int u = p[1];
            int v = p[0];

            adj.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0)
               q.add(i);
        }
        int count = 0;
        while(!q.isEmpty())
        {
            int node = q.poll();
            count++;
            for (int nei : adj.get(node))
            {
                indegree[nei]--;
                if(indegree[nei] == 0)
                q.add(nei);
            }
        }

        return count == numCourses;
    }
}