class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # if: length not equal, return false
        if len(s) != len(t):
            return False

        # initiate two freq tables (hashmap)
        sFreq = {}
        tFreq = {}

        # loop: iterate over strings through index
        # increment the value or init to 0
        for i in range(len(s)):
            firstChar = s[i]
            secondChar = t[i]
            sFreq[firstChar] = sFreq.get(firstChar, 0)+1
            tFreq[secondChar] = tFreq.get(secondChar, 0)+1

        # if: both tables are equal, return true, otherwise return false
        if sFreq == tFreq:
            return True
        else:
            return False
