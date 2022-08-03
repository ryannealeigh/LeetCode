class MyCalendar {

    List<int[]> intervals;
    public MyCalendar() {
        intervals = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        if (intervals.size() == 0) {
            intervals.add(new int[]{start, end});
            return true;
        }
        
        int left = 0, right = intervals.size() - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (mid == intervals.size() - 1 && intervals.get(mid)[1] <= start) {
                intervals.add(mid + 1, new int[]{start, end});
                return true;
            } else if (mid < intervals.size() - 1 && intervals.get(mid)[1] <= start && intervals.get(mid + 1)[0] >= end) {
                intervals.add(mid + 1, new int[]{start, end});
                return true;
            } else if (mid == 0 && intervals.get(mid)[0] >= end) {
                intervals.add(0, new int[]{start, end});
                return true;
            } else if (intervals.get(mid)[1] < start) {
                // go right
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */