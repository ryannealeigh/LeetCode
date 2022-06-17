class CombinationIterator {

    int current;
    List<String> combinations;
    
    public CombinationIterator(String characters, int combinationLength) {
        current = 0;
        combinations = new ArrayList<>();
        
        backtrack(characters, new StringBuilder(), 0, combinationLength);
    }
    
    private void backtrack(String characters, StringBuilder curr, int index, int targetLength) {
        if (curr.length() == targetLength) {
            combinations.add(curr.toString());
            return;
        }
        
        for (int i = index; i < characters.length(); i++) {
            curr.append(characters.charAt(i));
            backtrack(characters, curr, i + 1, targetLength);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
    
    public String next() {
        return combinations.get(current++);
    }
    
    public boolean hasNext() {
        return current < combinations.size();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */