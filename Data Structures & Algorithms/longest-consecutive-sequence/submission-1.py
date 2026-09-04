class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        # build a set from input array
        # init. longest streak to zero
        lookup = set(nums)
        longestStreak = 0
        
        # loop: iterate over the nums array. For each num:
        ## if: not a start of the seq., continue
        ## init. streak to 1
        ## init. next to num+1
        ## while: next in the set, increment next and streak
        ## if: streak > longest, update longest
        for num in nums:
            if num-1 in lookup:
                continue
            
            streak = 1
            next = num+1
            while next in lookup:
                streak += 1
                next += 1
            
            longestStreak = max(streak, longestStreak)

        ## return longest streak
        return longestStreak