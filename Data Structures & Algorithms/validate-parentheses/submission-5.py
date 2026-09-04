class Solution:
    def isValid(self, s: str) -> bool:
        # initialize an empty stack
        # initialize the map (closing -> opening)
        stack = []
        map = {
            ")" : "(",
             "}" : "{",
             "]" : "["
        }
        
        # loop: iterate over the string. For each bracket
        ## if: bracket is opening (if in the values()), push to the stack
        ## else:
        ## if: stack empty or bracket doesn't map, return false
        ## else: pop
        for bracket in s:
            if bracket in map.values():
                stack.append(bracket)
            else:
                if not stack or stack[-1] != map.get(bracket):
                    return False
                
                stack.pop()

        ## return is stack empty?
        return (not stack)
