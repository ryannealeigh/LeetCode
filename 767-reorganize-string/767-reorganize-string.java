class Solution {
    class Pair {
        char c;
        int count;
        
        public Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
    
    public String reorganizeString(String s) {
        // count characters in s
        // if any character has greater than n / 2 count then we return ""
        // starting with greatest character counts working down, insert chars to stringbuilder
        
        int n = s.length();
        
        HashMap<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Pair> heap = new PriorityQueue<>((a,b) -> Integer.compare(b.count, a.count));
        
        for (Character c : counts.keySet()) {
            heap.add(new Pair(c, counts.get(c)));
        }
        
        if ((n % 2 == 0 && heap.peek().count > n / 2) || (n % 2 != 0 && heap.peek().count > (n / 2) + 1)) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();

        while (result.length() < n) {
            Pair x = heap.poll();
            Pair y = null;
            if (heap.size() > 0) {
                y = heap.poll();
            }

            result.append(x.c);
            x.count--;
            if (x.count > 0) {
                heap.add(x);
            }
            
            if (result.length() == n) {
                break;
            }

            result.append(y.c);
            y.count--;
            if (y.count > 0) {
                heap.add(y);
            }
        }
        
        return result.toString();
    }
}