class Solution {
    public int maxArea(int[] heights) {
        // initialize maxArea to zero
        // initialize both left and right pointers
        int maximumArea = 0;
        int left = 0;
        int right = heights.length-1;
        
        // while: l < r
        //// calculate the area: height(height of shortest bar) * width (distnace between them)
        //// if: area > maxArea, update max area
        //// if: left height is lower, move rightward
        //// else: move leftward
        while (left < right) {
            int area = Math.min(heights[left], heights[right]) * (right - left);
            maximumArea = Math.max(area, maximumArea);

            if (heights[left] < heights[right])
                left++;
            else
                right--;
        }

        // return maxArea
        return maximumArea;
    }
}
