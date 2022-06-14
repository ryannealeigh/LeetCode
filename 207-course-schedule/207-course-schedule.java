class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> parentsMap = new HashMap<>();
        HashMap<Integer, Integer> counts = new HashMap<>();
        
        for (int i = 0; i < numCourses; i++) {
            counts.put(i, 0);
        }

        for (int[] row : prerequisites) {
            parentsMap.putIfAbsent(row[1], new ArrayList<Integer>());       // initialize list of children
            parentsMap.get(row[1]).add(row[0]);                             // add child course to list
            counts.put(row[0], counts.get(row[0]) + 1);                     // increment parents count for child course
        }
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        for (Integer i : counts.keySet()) {
            if (counts.get(i) == 0) {                   // add all nodes with 0 parents to queue
                queue.add(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            
            if (parentsMap.containsKey(currentCourse)) {
                for (int child : parentsMap.get(currentCourse)) {
                    counts.put(child, counts.get(child) - 1);
                    if (counts.get(child) == 0) {
                        queue.add(child);
                    }
                }
            }
        }
        
        for (Integer i : counts.keySet()) {
            if (counts.get(i) != 0) {                   // add all nodes with 0 parents to queue
                return false;
            }
        }
        return true;
    }
}