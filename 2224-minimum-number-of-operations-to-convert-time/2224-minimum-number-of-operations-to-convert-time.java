class Solution {
    public int convertTime(String current, String correct) {
        int result = 0;
        
        int currentHour = Integer.parseInt(current.substring(0, 2));
        int correctHour = Integer.parseInt(correct.substring(0, 2));
        
        int hourDiff = correctHour - currentHour;
                
        int currentMinutes = Integer.parseInt(current.substring(3, 5));
        int correctMinutes = Integer.parseInt(correct.substring(3, 5));
        
        int minuteDiff = correctMinutes - currentMinutes;
        
        if (currentMinutes > correctMinutes) {
            minuteDiff = (60 - currentMinutes) + correctMinutes;
        }
        
        if (currentMinutes + minuteDiff >= 60) {
            hourDiff--;
        }
                
        result += minuteDiff / 60;
        minuteDiff %= 60;
        
        result += minuteDiff / 15;
        minuteDiff %= 15;
        
        result += minuteDiff / 5;
        minuteDiff %= 5;
        
        result += minuteDiff;
        result += hourDiff;
        
        return result;
    }
}