class Solution {
    public String minWindow(String s, String t) {
        // build the lookup map from string t, initialize need = map.size()
        // initialize window map – keeps track of current window
        // initialize have  = 0
        // initialize left pointer to zero
        // init resStartIndex = -1, resLength = Infinity/max
        Map<Character, Integer> lookup = new HashMap<>();
        for (char c : t.toCharArray()) {
            lookup.put(c, lookup.getOrDefault(c, 0)+1);
        }
        int need = lookup.size();
        Map<Character, Integer> window = new HashMap<>();
        int have = 0;
        int left = 0;
        int resStartIndex = -1;
        int resLength = Integer.MAX_VALUE;

        // loop: iterate right = 0 through s.length-1. For each right:
        //// get the char
        //// if char in lookup:
        ////// add to window
        ////// if window[char] == lookup[char]: have++
        //// while (have == need):
        ////// if (r-l+1) < resLength: update resStartIndex and length
        ////// get char
        ////// if char in window: 
        //////// window[char]--
        //////// if window[char] < lookup[char]: have--
        ////// l++
        for (int right = 0; right < s.length(); right++) {
            char curChar = s.charAt(right);
            if (lookup.containsKey(curChar)) {
                window.put(curChar, window.getOrDefault(curChar, 0)+1);
                if (window.get(curChar).equals(lookup.get(curChar)))
                    have++;
            }
            
            while (have == need) {
                if ((right-left+1) < resLength) {
                    resStartIndex = left;
                    resLength = right-left+1;
                }
                char removeChar = s.charAt(left);
                if (window.containsKey(removeChar)) {
                    window.put(removeChar, window.get(removeChar)-1);
                    if (window.get(removeChar) < lookup.get(removeChar))
                        have--;
                }
                left++;
            }
        }

        // if: resStartIndex = -1: return ""
        // else: return s.substring(l, l+resLength)
        if (resStartIndex == -1)
            return "";
        else
            return s.substring(resStartIndex, resStartIndex+resLength);
    }
}
