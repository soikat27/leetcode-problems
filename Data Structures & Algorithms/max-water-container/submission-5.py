class Solution:
    def maxArea(self, heights: List[int]) -> int:
        # initialize maxArea to zero
        # initialize left and right pointers to both end indices
        maximumArea = 0
        left = 0
        right = len(heights)-1

        # while: left < right
        ## calculate the area
        ## assign max(area, maxArea) to maxarea
        ## if: left bar height is lower, shift left bar rightward
        ## else: move right bar leftward
        while left < right:
            area = min(heights[left], heights[right]) * (right-left)
            maximumArea = max(area, maximumArea)

            if heights[left] < heights[right]:
                left += 1
            else:
                right -= 1

        # return maxarea
        return maximumArea
