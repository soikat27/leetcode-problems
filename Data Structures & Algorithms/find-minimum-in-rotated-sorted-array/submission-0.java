class Solution {
    public int findMin(int[] nums) {
        // initialize l and r
        // initialize min = num[0]
        int left = 0, right = nums.length-1;
        int min = nums[0];
        
        // while: l <= r:
        //// if: the window is sorted – [l] <= [r], update min and return [l]
        //// find mid num
        //// update min
        //// if: mid >= [l], search right portion
        //// else: search left portion
        while (left <= right) {
            if (nums[left] <= nums[right]) {
                min = Math.min(min, nums[left]);
                break;
            }

            int mid = left + (right-left)/2;
            min = Math.min(min, nums[mid]);
            if (nums[mid] >= nums[left])
                left = mid+1;
            else
                right = mid-1;
        }

        // return min
        return min;
    }
}
