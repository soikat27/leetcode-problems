class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // initiate a lookup map (key: sorted-string, value: list of strings)
        HashMap<String, List<String>>lookup = new HashMap<>();

        // loop: iterate over the strings in the array
        // sort the string. if: the sorted-string in the map, add to the value list
        // otherwise, put it into the map and map it to an empty list(adding curString)
        for (String curString : strs) {
            char[] chars = curString.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);

            if (lookup.containsKey(sortedString))
                lookup.get(sortedString).add(curString);
            else {
                List<String> newList = new ArrayList<>();
                newList.add(curString);
                lookup.put(sortedString, newList);
            }      
        }

        // initiate arraylist of string-lists, to be returned
        List<List<String>> anagrams = new ArrayList<>();

        // loop: iterate over the value set
        // push it to the arraylist
        for (List<String> group : lookup.values()) {
            anagrams.add(group);
        }

        // return anagrams list
        return anagrams;
    }
}
