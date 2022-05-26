class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // initialize the left and right bounds
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int speed = left + (right - left) / 2;
            int hoursSpent = 0;

            // see how many hours it will take with current speed
            for (int pile : piles) {
                hoursSpent += Math.ceil((double) pile / speed);
            }

            // if our hours taken for k is less than or equal to hours, then it is a valid k,
            // but may be too high so we will check slower speeds
            if (hoursSpent <= h) {
                right = speed;
            } else {
                left = speed + 1;
            }
        }
        
        return right;
    }
}