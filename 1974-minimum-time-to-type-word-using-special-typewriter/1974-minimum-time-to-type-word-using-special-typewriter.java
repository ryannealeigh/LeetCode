class Solution {
    public int minTimeToType(String word) {
        // take Math.min(Math.abs(charA - charB), 
        // 'z' - 'a' = 26
        // 'f' - 'a' = 6
        // 'i' - 'a' = 9
        // 't' - 'a' = 19
        // 'd' - 'a' = 3
        // e.g. "id"
        // to go cw from i to d would take 'z' - 'i' + 'd' - 'a' + 1 time
        // to go ccw from d to x would take 'd' - 'a' + 'z' - 'x' + 1 time
        
        // find the absolute difference between the 2 characters
        // find the absolute different between the 2 characters crossing the z/a boundary
        // this is 'z' - larger character + smaller character - 'a' + 1
        // e.g. "dw"
        // z - w = 3
        // d - a = 3
        // added up = 6, but this is one short
        // add 1 to account for z/a divide and result is 7
        // take Math.min(absolute diff, z/a boundary)
        
        char curr = 'a';
        char[] chars = word.toCharArray();
        
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            char next = chars[i];
            char larger = next > curr ? next : curr;
            char smaller = next < curr ? next : curr;
            
            int diff = larger - smaller;
            count += Math.min(diff, 26 - diff);
            count++;
            curr = next;
        }
        
        return count;
    }
}