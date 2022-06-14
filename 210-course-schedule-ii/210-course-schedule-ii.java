class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {        
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            counts.put(i, 0);
        }
        
        for (int[] row : prerequisites) {
            graph.putIfAbsent(row[1], new ArrayList<Integer>());        // init list of edges
            graph.get(row[1]).add(row[0]);                  // add parent child connection
            counts.put(row[0], counts.get(row[0]) + 1);     // increment parents count
        }
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (Integer node : counts.keySet()) {              // add all courses with no prerequisite
            if (counts.get(node) == 0) {
                queue.add(node);
            }
        }
        
        int coursesFinished = 0;
        int[] result = new int[numCourses];

        while (!queue.isEmpty()) {
            Integer course = queue.poll();
            result[coursesFinished] = course;
            coursesFinished++;
            
            if (graph.containsKey(course)) {
                for (Integer child : graph.get(course)) {
                    counts.put(child, counts.get(child) - 1);
                    if (counts.get(child) == 0) {
                        queue.add(child);
                    }
                }
            }
        }
        
        if (coursesFinished == numCourses) {
            return result;
        }
        return new int[]{};
    }
}