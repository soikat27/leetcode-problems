class Solution {
    public int lengthOfLongestSubstring(String s) {
        // initialize longest substring length to zero
        // initialize left and right pointers – both = 0
        // initialize set of char – representing the window
        int longest = 0;
        int left = 0;
        int right = 0;
        Set<Character> window = new HashSet<>();

        // while: right within the bound
        //// if: [right] is NOT in the set 
        ////// update longest substring length
        ////// increment right pointer
        //// else:
        ////// while: [right] in the set
        //////// remove [left] from the set
        //////// left++
        //// push [right] into the set
        while (right < s.length()) {
            if (!window.contains(s.charAt(right)))
                longest = Math.max(right-left+1, longest);
            else {
                while (window.contains(s.charAt(right)))
                    window.remove(s.charAt(left++));
            }

            window.add(s.charAt(right));
            right++; 
        }

        // return longest substring length
        return longest;
    }
}
