class Solution {
    public int characterReplacement(String s, int k) {
        // initialize longest substring length (acoouting for replacements) to zero
        // initilaize left pointer to zero
        // initialize empty hashmap – representing window
        int longest = 0;
        int left = 0;
        Map<Character, Integer> window = new HashMap<>();

        // iterate through right 0 to s.length-1. for each right pointer index:
        //// push [right] to the hashmap
        //// get most frequency from the window. iterate over values()
        //// while: len(window) - most frequency > k:
        ////// decrement window[left] freq.
        ////// update most frequency
        //// update logest substring length
        for (int right = 0; right < s.length(); right++) {
            window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0)+1);
            int mostFreq = getMostFrequency(window);

            while ((right-left+1) - mostFreq > k) {
                window.put(s.charAt(left), window.get(s.charAt(left))-1);
                left++;
                mostFreq = getMostFrequency(window);
            }

            longest = Math.max(longest, (right-left+1));
        }

        // return longest substring length
        return longest;
    }

    private int getMostFrequency(Map<Character, Integer> map) {
        int mostFreq = 0;

        for (int value : map.values())
            mostFreq = Math.max(mostFreq, value);
        
        return mostFreq;
    }
}
