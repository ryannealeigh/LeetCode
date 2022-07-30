class Solution {

    public List<String> wordSubsets(String[] words1, String[] words2) {
        HashMap<String, HashMap<Character, Integer>> aMaps = new HashMap<>();

        for (String a : words1) {
            aMaps.putIfAbsent(a, new HashMap<>());
            HashMap<Character, Integer> aMap = aMaps.get(a);

            for (int j = 0; j < a.length(); j++) {
                char c = a.charAt(j);
                aMap.put(c, aMap.getOrDefault(c, 0) + 1);
            }
        }

        HashMap<Character, Integer> bMap = new HashMap<>();

        for (String b : words2) {
            HashMap<Character, Integer> currMap = new HashMap<>();

            for (int j = 0; j < b.length(); j++) {
                char c = b.charAt(j);
                currMap.put(c, currMap.getOrDefault(c, 0) + 1);
                bMap.putIfAbsent(c, 0);
                bMap.put(c, Math.max(currMap.get(c), bMap.get(c)));
            }
        }

        List<String> result = new ArrayList<>();

        for (String a : words1) {
            boolean universal = true;
            HashMap<Character, Integer> aMap = aMaps.get(a);

            for (Character c : bMap.keySet()) {
                if (!aMap.containsKey(c) || aMap.get(c) < bMap.get(c)) {
                    universal = false;
                    break;
                }
            }

            if (universal) {
                result.add(a);
            }
        }

        return result;
    }
}
