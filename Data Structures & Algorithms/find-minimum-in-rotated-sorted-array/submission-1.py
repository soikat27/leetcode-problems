class Solution:
    def findMin(self, nums: List[int]) -> int:
        # initialize left and right
        # initialize min – nums[0]
        left, right = 0, len(nums)-1
        minValue = nums[0]

        # while: l <= r:
        ## if the window is sorted – [l] <= [r], update min, break
        ## find mid
        ## update min
        ## if [mid] >= [left]: search right portion
        ## else: search left portion
        while left <= right:
            if nums[left] <= nums[right]:
                minValue = min(nums[left], minValue)
            
            mid = left + (right-left)//2
            minValue = min(minValue, nums[mid])

            if (nums[mid] >= nums[left]):
                left = mid+1
            else:
                right = mid-1

        # return min
        return minValue
        