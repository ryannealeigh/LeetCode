class Solution {
    public int uniqueLetterString(String s) {
        // initialize everything with -1, this will ensure charactersLastIdx[idx] + 1 is 0 
		// if character not seen yet
        int[] charactersLastIdx = new int[26];
        Arrays.fill(charactersLastIdx, -1);
        
        int[] currentCharContribution = new int[26];
        
        int totalUniqueCharSubstrings = 0;
        
        for(int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'A';
            
            // if charactersLastIdx[idx] is nonzero, that means it contributed from 0 to to its last index 
            currentCharContribution[idx] = i+1 - (charactersLastIdx[idx] + 1);
            
            for(int j = 0; j < 26; j++) totalUniqueCharSubstrings += currentCharContribution[j];
            
            charactersLastIdx[idx] = i;
        }
        
        return totalUniqueCharSubstrings;
    }
}
