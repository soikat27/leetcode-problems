class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # initiate the "seen" map
        seen = {}
        
        # loop: iterate over the array through index.
        # if: the diff is in the "seen" map, return the array of indices [x: (retrieved from the map), y: (current index)]
        # otherwise, put (key: num, value: index)
        for i in range(len(nums)):
            diff = target - nums[i]

            if diff in seen:
                return [seen[diff], i]
            
            seen[nums[i]] = i
