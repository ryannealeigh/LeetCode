import java.lang.StringBuilder;

class RemoveVowels {
    public static void main(String[] args) {
        RemoveVowels obj = new RemoveVowels();
        System.out.println(obj.removeVowels("leetcodeisacommunityforcoders"));
    }

    public String removeVowels(String S) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != 'a' && S.charAt(i) != 'e' && S.charAt(i) != 'i'
                && S.charAt(i) != 'o' && S.charAt(i) != 'u') {
                // System.out.println("Char at i = " + S.charAt(i));
                sb.append(S.charAt(i));
            }
        }

        return sb.toString();
    }
}