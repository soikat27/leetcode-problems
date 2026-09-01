class Solution {
    public boolean isAnagram(String s, String t) {
        // if: different lengths, return false
        if (s.length() != t.length())
            return false;

        // initiate a common freq map
        HashMap<Character, Integer> freqMap = new HashMap<>();

        // loop: iterate over strings through index.
        // increment the curernt value, for the firstChar key
        // decrement the curernt value, for the secondChar key
        for (int i = 0; i < s.length(); i++) {
            char firstChar = s.charAt(i);
            char secondChar = t.charAt(i);

            freqMap.put(firstChar, freqMap.getOrDefault(firstChar, 0)+1);
            freqMap.put(secondChar, freqMap.getOrDefault(secondChar, 0)-1);
        }

        // loop: iterate over map.values(), if not zero return false
        // exits loop: return true
        for (int value : freqMap.values()) {
            if (value != 0)
                return false;
        }
        return true;
    }
}