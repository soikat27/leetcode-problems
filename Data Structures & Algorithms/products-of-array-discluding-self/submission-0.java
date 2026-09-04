class Solution {
    public int[] productExceptSelf(int[] nums) {
        // initialize empty output array
        int[] output = new int[nums.length];

        // initialize prefix to 1
        // prefix loop: iterate through index: 0 to nums length-1. For each index:
        //// put the prefix in output array at current index
        //// update the prefix: prefix * nums at current index
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            output[i] = prefix;
            prefix *= nums[i];
        }

        // initialize postfix to 1
        // postfix loop: iterate through the indices: nums.length-1 through 0. For each index
        //// put (multiply) the postfix in output at current index
        //// update the postfix: postfix * nums at the current index
        int postfix = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            output[i] *= postfix;
            postfix *= nums[i];
        }

        // return output
        return output;
    }
}  
