class Solution:
    def minWindow(self, s: str, t: str) -> str:
        # build lookup map from string t and initialize need = len(lookup)
        # initialize window map – keeps track of current window
        # initialize have = 0
        # initialize left = 0
        # initialize resStartIndex = 0 and resLength = positive infinity
        lookup = {}
        for char in t:
            lookup[char] = 1 + lookup.get(char, 0)
        need = len(lookup)
        window = {}
        have = 0
        left = 0
        resStartIndex = -1
        resLength = float("inf")

        # loop: iterate over right = 0 through len(s)-1. For each right:
        ## get rightChar and add to window
        ## if: char in lookup and window[rightChar] == lookup[rightChar], have++
        ## while (have == need)
        #### if ((right-left+1) < resLength): update resStartIndex and resLength
        #### get leftChar and decrement from window
        #### if leftChar in lookup and window[leftChar] < lookup[leftChar]: have--;
        ####left++;
        for right in range(len(s)):
            rightChar = s[right]
            window[rightChar] = 1 + window.get(rightChar, 0)

            if (rightChar in lookup and window[rightChar] == lookup[rightChar]):
                have += 1
            
            while have == need:
                if (right-left+1) < resLength:
                    resStartIndex = left
                    resLength = right-left+1
                
                leftChar = s[left]
                window[leftChar] = window.get(leftChar, 0)-1
                if leftChar in lookup and window[leftChar] < lookup[leftChar]:
                    have -= 1
                left += 1

        ## if resStartIndex == -1, return ""
        ## else: return substring
        if resStartIndex == -1:
            return ""
        else:
            return s[resStartIndex:(resStartIndex+resLength)]
