class Solution:

    def encode(self, strs: List[str]) -> str:
        # initialize empty list
        encodedString = []
        
        # loop: iterate over the strings. For each string
        ## append the concat(length+#+string)
        for string in strs:
            encode = str(len(string)) + "#" + string
            encodedString.append(encode);

        # join the list and return
        return "".join(encodedString)

    def decode(self, s: str) -> List[str]:
        # initialize i = 0
        # initialize empty list
        decodedList = []
        i = 0
        
        # loop: iterate till i < str length. For each i:
        ## initialize j = i+1
        ## loop: increment j until j == #
        ## get the length of the string from substring
        ## move i after j
        ## move j to the char after the string
        ## get the substring and add to the list
        ## move i in place of j
        while i < len(s):
            j = i+1
            while s[j] != '#':
                j += 1

            length = s[i:j]
            i = j+1
            j = i + int(length)

            decodedList.append(s[i:j])
            i = j

        # return the list
        return decodedList