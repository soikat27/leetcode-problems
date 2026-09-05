class Solution:
    def isPalindrome(self, s: str) -> bool:
        # init. left and right pointers
        left = 0
        right = len(s)-1

        # while: left < right
        ## keep incrementing left till left < right and not alphanemeric
        ## keep decrementing left till left < right and not alphanemeric
        ## if: chars indexed at left and right not same, return false
        ## else: update left and right pointers
        while left < right:
            while left < right and not s[left].isalnum():
                left += 1
            while right > left and not s[right].isalnum():
                right -= 1

            if s[left].lower() != s[right].lower():
                return False
            
            left += 1
            right -= 1

        # exits the loop: return true
        return True