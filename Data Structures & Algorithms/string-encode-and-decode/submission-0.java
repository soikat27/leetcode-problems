class Solution {

    public String encode(List<String> strs) {
        // initiate an empty stringbuilder
        StringBuilder encodedString = new StringBuilder();
        
        // loop: iterate over the list
        // for each string:
        //// append length & delimeter(#) & string 
        for (String string : strs) {
            String encode = String.format("%d#%s", string.length(), string);
            encodedString.append(encode);
        }

        // return string
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        // initiate empty decoded list
        // initiate index
        // get encoded string length
        List<String> decodedArray = new ArrayList<>();
        int index = 0;
        int totalLength = str.length();

        // loop: iterate until index equals stringlength
        //// initiate empty string builder
        //// get the length
        //// increment past the delimeter
        //// calculate final index for this word
        //// loop: iterate upto the final length
        ////// append to the stringbuilder
        //// push the string to the decoded list
        while (index < totalLength) {
            StringBuilder strBuilder = new StringBuilder();

            String lengthString = "";
            while (Character.isDigit(str.charAt(index))) {
                lengthString += str.charAt(index++);
            }
            int length = Integer.parseInt(lengthString);

            index++;
            int finalIndex = index+length;

            for (; index < finalIndex; index++) {
                strBuilder.append("" + str.charAt(index));
            }
            decodedArray.add(strBuilder.toString());
        }

        return decodedArray;
    }
}
