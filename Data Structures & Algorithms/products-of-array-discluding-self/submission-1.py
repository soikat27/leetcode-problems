class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        # initialize the output
        output = [0] * len(nums);

        # initialize prefix to 1
        # prefix loop: iterate indices 1 through nums.length-1. For each index:
        ## put prefix in output at current index
        ## update prefix: multiply with nums[index]
        prefix = 1
        for i in range(len(nums)):
            output[i] = prefix
            prefix *= nums[i]

        # initialize postfix to 1
        # postfix loop: iterate indices nums.length-1 through 0. For each index:
        ## put postfix in output at current index (multiply)
        ## update postfix: multiply with nums[index]
        postfix = 1
        for i in range(len(nums)-1, -1, -1):
            output[i] *= postfix
            postfix *= nums[i]
        
        # return output
        return output