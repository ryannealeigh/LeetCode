class Solution {
    public String[] reorderLogFiles(String[] logs) {        
        ArrayList<String> letterLogs = new ArrayList<>();

        for (String str : logs) {
            String[] split = str.split(" ", 2);
            char first = split[1].charAt(0);
            if (first >= 'a' && first <= 'z') {
                letterLogs.add(str);
            }
        }
        
        Collections.sort(letterLogs, (a, b) -> compareLet(a, b));
                
        String[] result = new String[logs.length];
        int i = 0;

        for (String str : letterLogs) {
            result[i++] = str;
        }
        
        if (i == logs.length) {
            return result;
        }
        
        for (String str : logs) {
            String[] split = str.split(" ", 2);
            char first = split[1].charAt(0);
            if (first >= '0' && first <= '9') {
                result[i++] = str;
            }
        }
        
        return result;
    }
                    
    private int compareLet(String s1, String s2) {
        String[] split1 = s1.split(" ", 2);
        String[] split2 = s2.split(" ", 2);
        
        if (split1[1].equals(split2[1])) {
            return split1[0].compareTo(split2[0]);
        }
        
        return split1[1].compareTo(split2[1]);
    }
}