class Solution {
    public boolean isValid(String s) {
        // initialize an empty stack
        // build bracket map
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character>map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        // loop: iterate over the chars from the stri value). for each bracket
        //// if: bracket in the values of map, push
        //// else:
        ////// if: stack empty or no match (top doesn't map to the char), return false
        ////// else: pop from the stack
        for (char bracket : s.toCharArray()) {
            if (map.containsValue(bracket))
                stack.push(bracket);
            else {
                if (stack.isEmpty() || stack.peek() != map.get(bracket))
                    return false;
                
                stack.pop();
            }
        }

        // if: stack is empty, return true, otherwise false
        return stack.isEmpty();
    }
}
