class Solution {

    public int maxArea(int[] height) {
        int front = 0;
        int back = height.length - 1;
        int maxArea = 0;

        while (front != back) {
            int area = Math.min(height[front], height[back]) * (back - front);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[front] < height[back]) {
                front++;
            } else {
                back--;
            }
        }
        return maxArea;
    }
}
