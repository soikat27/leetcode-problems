class Solution:
    def search(self, nums: List[int], target: int) -> int:
        # initialize left and right pointers
        left, right = 0, len(nums)-1

        # while: valid window – left <= right
        ## compute the mid
        ## if [mid] == target, return mid index
        ## check if [mid] in left or right portion
        ## if [mid] in left
        #### if target > [mid] or target < [left]: search right
        #### else: search left 
        ## else: – [mid] in right
        #### if target < [mid] or target > [right]: serach left
        #### else: search right
        while left <= right:
            mid = left + (right-left)//2
            if nums[mid] == target:
                return mid
            
            if nums[mid] >= nums[left]:
                if target > nums[mid] or target < nums[left]:
                    left = mid+1
                else:
                    right = mid-1
            else:
                if target < nums[mid] or target > nums[right]:
                    right = mid-1
                else:
                    left = mid+1

        # return -1 – target not found
        return -1
