class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int half = length / 2;
        
        int[] a = nums1.length <= nums2.length ? nums1 : nums2;
        int[] b = nums1.length <= nums2.length ? nums2 : nums1;
        
        int left = 0, right = a.length - 1;
        
        while (true) {
            int i;
            if (right < 0) {
                i = -1;
            } else {
                i = left + (right - left) / 2;  // A pointer
            }
            int j = half - i - 2;               // B pointer
            
            int aLeft = i >= 0 ? a[i] : Integer.MIN_VALUE;
            int aRight = i + 1 < a.length ? a[i + 1] : Integer.MAX_VALUE;
            int bLeft = j >= 0 ? b[j] : Integer.MIN_VALUE;
            int bRight = j + 1 < b.length ? b[j + 1] : Integer.MAX_VALUE;
            
            // left partition is correct
            if (aLeft <= bRight && bLeft <= aRight) {
                // odd case
                if (length % 2 != 0) {
                    return (double) Math.min(aRight, bRight);
                } else {
                    return (double) (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0;
                }
            } else if (aLeft > bRight) {
                // we have too many elements from A
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
    }
}