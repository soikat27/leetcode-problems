class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // initiate an empty lookup table
        HashMap<String, List<String>> lookup = new HashMap<>();

        // loop: iterate over the strings from the input array
        // initiate the empty [26] freqMap
        //// loop: iterate over the chars in the string
        //// build the freqMap
        // put the entry [key: tostring of the freqMap, value: empty list] ifAbsent
        // push the current string into the list under that key
        for (String string : strs) {
            int[] freqMap = new int[26];
            for (char character : string.toCharArray()) {
                freqMap[character - 'a']++;
            }

            String key = Arrays.toString(freqMap);
            lookup.putIfAbsent(key, new ArrayList<String>());
            lookup.get(key).add(string);
        }

        // create arrayList from the map values()
        // return the arrayList
        List<List<String>> anagrams = new ArrayList<>(lookup.values());
        return anagrams;
    }
}
