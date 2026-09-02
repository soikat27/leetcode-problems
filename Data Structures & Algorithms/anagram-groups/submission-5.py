class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # initiate an empty lookup dict
        lookup = {}

        # loop: iterate over the strings
        # initiate an empty [26] freqMap
        ## loop: iterate over the characters
        ## update freq
        # build the key: string of the freqMap
        # add value: empty list, if key absent
        # push to the value: list, under the key
        for string in strs:
            freqMap = [0] * 26
            for character in string:
                index = ord(character) - ord('a')
                freqMap[index] += 1
            
            key = tuple(freqMap)
            lookup.setdefault(key, [])
            
            lookup[key].append(string)

        # build and return the array: having values()
        anagrams = list(lookup.values())
        return anagrams