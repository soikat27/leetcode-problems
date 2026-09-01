class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # if: length not equal, return false
        if len(s) != len(t):
            return False

        # initiate two freq tables (hashmap)
        freqMap = {}

        # loop: iterate over strings through index
        # increment the value or init to 0
        for i in range(len(s)):
            firstChar = s[i]
            secondChar = t[i]
            freqMap[firstChar] = freqMap.get(firstChar, 0)+1
            freqMap[secondChar] = freqMap.get(secondChar, 0)-1

        # if: both tables are equal, return true, otherwise return false
        for value in freqMap.values():
            if value != 0:
                return False
        
        return True