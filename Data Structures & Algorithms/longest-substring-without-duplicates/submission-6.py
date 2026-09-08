class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # initialize longest substring length to zero
        # initialize left and right pointers to 0
        # initialize a set representing the window
        longest = 0
        left = 0
        window = set()

        # iterate over right = 0 through s.length-1. For each right index:
        ## while: [right] in the set
        #### remove [left] and increment left
        ## add right to the set
        ## update longest substring length
        for right in range(len(s)):
            while s[right] in window:
                window.remove(s[left])
                left += 1
            
            window.add(s[right])
            longest = max(longest, right-left+1)
        
        # return longest substring length
        return longest
            

