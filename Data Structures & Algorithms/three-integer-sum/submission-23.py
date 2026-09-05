class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # sort nums
        # initialize output list
        nums.sort()
        output = []
        
        # loop: iterate through index 1 through nums.length-3
        ## if: index > 0 and duplicate (seen before), skip to next iteration
        ## initialize left and right pointers
        ## while: left < right
        #### calculate sum
        #### if: sum == 0, append to output. update both pointers and skip if duplicates
        #### else if: sum < 0, update left pointer, skip till there's duplicates
        #### else: update right pointer, skip till there's duplicates
        for i, num in enumerate(nums):
            if i > 0 and num == nums[i-1]:
                continue
            
            left = i+1
            right = len(nums)-1

            while (left < right):
                sum = num + nums[left] + nums[right]

                if sum == 0:
                    output.append([num, nums[left], nums[right]])

                    left += 1
                    while left < right and nums[left] == nums[left-1]:
                        left += 1

                    right -= 1
                    while right > left and nums[right] == nums[right+1]:
                        right -= 1
                
                elif sum < 0:
                    left += 1
                    while left < right and nums[left] == nums[left-1]:
                        left += 1
                
                else:
                    right -= 1
                    while right > left and nums[right] == nums[right+1]:
                        right -= 1
                
        # return output
        return output