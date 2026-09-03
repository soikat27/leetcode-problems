class Solution {

    public String encode(List<String> strs) {
        // initialize a string builder
        StringBuilder encodedString = new StringBuilder();
        
        // loop: iterate over strs
        //// append length, #, string itself
        for (String string : strs) {
            encodedString.append(string.length()).append("#").append(string);
        }

        // return the string from string builder
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        // initialize the empty list of strings
        // initialize index to iterate over encoded string
        List<String> decodedArray = new ArrayList<>();
        int i = 0;

        // loop: interate till index < str length
        //// initialize j=i+1 to retrieve the length
        //// increment j until it hits "#"
        //// get length from i, j substring
        //// bring i to the first char of the string i=j+1
        //// bring j to the first char after the string
        //// get subString and append to the list
        //// bring i to j
        while (i < str.length()) {
            int j = i+1;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));

            i = j+1;
            j = i+length;
            decodedArray.add(str.substring(i, j));

            i = j;
        }

        // return the list
        return decodedArray;
    }
}
