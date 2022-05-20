public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(str.length() + "#" + str);
        }
        
        return encoded.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i = 0;
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != '#') {
                j++;
            }
            int stringLength = Integer.parseInt(s.substring(i, j));
            i = j + 1;
            
            int current = i;
            
            while (current < i + stringLength) {
                sb.append(s.charAt(current++));
            }
            result.add(sb.toString());
            sb.setLength(0);
            i = current;
        }
        
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));