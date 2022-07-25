class Solution {
    private HashMap<Integer, String> WORDS = new HashMap<>();
        
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        
        WORDS.put(1, "One");
        WORDS.put(2, "Two");
        WORDS.put(3, "Three");
        WORDS.put(4, "Four");
        WORDS.put(5, "Five");
        WORDS.put(6, "Six");
        WORDS.put(7, "Seven");
        WORDS.put(8, "Eight");
        WORDS.put(9, "Nine");
        WORDS.put(10, "Ten");
        WORDS.put(11, "Eleven");
        WORDS.put(12, "Twelve");
        WORDS.put(13, "Thirteen");
        WORDS.put(14, "Fourteen");
        WORDS.put(15, "Fifteen");
        WORDS.put(16, "Sixteen");
        WORDS.put(17, "Seventeen");
        WORDS.put(18, "Eighteen");
        WORDS.put(19, "Nineteen");
        WORDS.put(20, "Twenty");
        WORDS.put(30, "Thirty");
        WORDS.put(40, "Forty");
        WORDS.put(50, "Fifty");
        WORDS.put(60, "Sixty");
        WORDS.put(70, "Seventy");
        WORDS.put(80, "Eighty");
        WORDS.put(90, "Ninety");

        int count = 1;
        StringBuilder sb = new StringBuilder();
        
        while (num > 0) {
            if (count % 3 == 0) {
                int digit = num % 10;
                if (digit != 0) {
                    sb.insert(0, "Hundred ");
                    sb.insert(0, WORDS.get(digit) + " ");
                }
                num /= 10;
                count++;
            }
            if (num == 0) {
                break;
            }
            if (count == 4) {
                if (num % 1000 != 0)
                    sb.insert(0, "Thousand ");
            } else if (count == 7) {
                if (num % 1000 != 0)
                    sb.insert(0, "Million ");
            } else if (count == 10) {
                if (num % 1000 != 0)
                    sb.insert(0, "Billion ");
            }
            
            int digits = num % 100;
            if (WORDS.containsKey(digits)) {
                sb.insert(0, WORDS.get(digits) + " ");
                num /= 100;
            } else {
                digits = num % 10;
                if (WORDS.containsKey(digits))
                    sb.insert(0, WORDS.get(digits) + " ");
                num /= 10;
                digits = (num % 10) * 10;
                if (WORDS.containsKey(digits))
                    sb.insert(0, WORDS.get(digits) + " ");
                num /= 10;
            }
            count += 2;
        }
        
        return sb.substring(0, sb.length() - 1);
    }
}