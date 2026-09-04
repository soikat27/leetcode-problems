class Solution {
    public boolean isPalindrome(String s) {
        // initialize left and right pointers
        int left = 0;
        int right = s.length()-1;

        // while: left < right
        //// get next alphanumeric left – while: left< right char indexed left isn't alpha., increment
        //// get next alphanumeric right – while: left < r and char indexed right isn't alpha., decrement
        //// if: left char != right char, return false 
        //// else: update left and right pointer
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;
            while (right > left && !Character.isLetterOrDigit(s.charAt(right)))
                right--;
            
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;

            left++;
            right--;
        }

        // exits loop: return true
        return true;
        
    }
}
