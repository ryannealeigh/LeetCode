class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] bmax = count("");
        for (String b: B) {
            int[] bCount = count(b);
            for (int i = 0; i < 26; ++i)
                bmax[i] = Math.max(bmax[i], bCount[i]);
        }

        List<String> ans = new ArrayList();
        
        for (String a: A) {
            boolean universal = true;
            int[] aCount = count(a);
            for (int i = 0; i < 26; ++i) {
                if (aCount[i] < bmax[i]) {
                    universal = false;
                    break;
                }
            }
            
            if (universal) {
                ans.add(a);
            }
        }

        return ans;
    }

    public int[] count(String S) {
        int[] ans = new int[26];
        for (char c: S.toCharArray())
            ans[c - 'a']++;
        return ans;
    }
}