class Solution {

    public int minDeletions(String s) {
        HashMap<Character, Integer> counts = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        HashSet<Integer> unique = new HashSet<>();

        int removed = 0;
        for (Character c : counts.keySet()) {
            int val = counts.get(c);
            while (unique.contains(val)) {
                if (val > 0) {
                    removed++;
                    val--;
                } else {
                    break;
                }
            }
            unique.add(val);
        }

        return removed;
    }
}
