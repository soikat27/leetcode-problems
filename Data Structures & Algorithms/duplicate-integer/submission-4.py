class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        # initiate a lookup set
        lookup = set()

        # iterate over the array
        # if: num is in the lookup, return true; otherwise, add num to the lookup
        # if exits: return false
        for num in nums:
            if num in lookup:
                return True
            
            lookup.add(num)
        
        return False