class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        int twenties = 0;
        
        for (int bill : bills) {
            if (bill == 5) {
                fives++;
            } else if (bill == 10) {
                tens++;
                if (fives == 0) {
                    return false;
                }
                fives--;
            } else {
                twenties++;
                if (tens > 0) {
                    tens--;
                    if (fives == 0) {
                        return false;
                    }
                    fives--;
                } else {
                    if (fives < 3) {
                        return false;
                    }
                    fives -= 3;
                }
            }
        }
        
        return true;
    }
}