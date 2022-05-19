public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        // encoded.append(strs.size());
        for (int i = 0; i < strs.size(); i++) {
            encoded.append(strs.get(i));
            if (i < strs.size() - 1) {
                encoded.append("BBRREEAAKK");
            }
        }
        
        return encoded.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        ArrayList<String> result = new ArrayList<>();
        // int n = Integer.parseInt(s.substring(0, 1));
        // s = s.substring(1);
        String[] split = s.split("BBRREEAAKK", -1);
        
        for (String str : split) {
            result.add(str);
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));