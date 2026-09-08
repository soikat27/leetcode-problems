class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        # initialize longest substring length
        # initialize left pointer
        # initialize empty map – represents current window
        longest = 0
        left = 0
        window = {}

        # iterate over right 0 through len(s)-1. For each right index:
        ## increment [right] to the map
        ## while: window invalid – len(window) - mostFreq. > k
        #### decrement [left]
        #### move left rightward
        ## update logest
        for right in range(len(s)):
            window[s[right]] = 1 + window.get(s[right], 0)

            while (right-left+1) - max(window.values()) > k:
                window[s[left]] -= 1
                left += 1
            
            longest = max(longest, (right-left+1))

        # return longest
        return longest