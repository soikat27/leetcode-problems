class Solution {
    public boolean isAnagram(String s, String t) {
        // if: different lengths, return false
        if (s.length() != t.length())
            return false;

        // initiate freq map for both strings
        HashMap<Character, Integer> sFreq = new HashMap<>();
        HashMap<Character, Integer> tFreq = new HashMap<>();

        // loop: iterate over strings through index.
        // increment the curernt value or set default value 0, for the curNumber key
        for (int i = 0; i < s.length(); i++) {
            char firstChar = s.charAt(i);
            char secondChar = t.charAt(i);

            sFreq.put(firstChar, sFreq.getOrDefault(firstChar, 0)+1);
            tFreq.put(secondChar, tFreq.getOrDefault(secondChar, 0)+1);
        }

        // if: maps are equal, return true; otherwise, return false
        if (sFreq.equals(tFreq))
            return true;
        else
            return false;
    }
}
