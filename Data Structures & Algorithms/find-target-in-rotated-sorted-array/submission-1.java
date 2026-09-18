class Solution {
    public int search(int[] nums, int target) {
        // initialize left and right pointers
        int left = 0, right = nums.length-1;

        // while: valid window – left <= right
        //// compute mid
        //// if [mid] == target, return mid index
        // check if [mid] in left or right sorted portion
        // if [mid] in left portion
        //// if target > [mid] or target < [left]: search right
        //// else: search left
        // else: [mid] in right portion
        //// if target < [mid] or target > [right]: search left
        //// else: search right
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (nums[mid] == target)
                return mid;
            
            // left sorted portion
            if (nums[mid] >= nums[left]) {
                if (target > nums[mid] || target < nums[left])
                    left = mid+1;
                else
                    right = mid-1;
            }

            // right sorted portion
            else {
                if (target < nums[mid] || target > nums[right])
                    right = mid-1;
                else
                    left = mid+1;
            }
        }

        // return -1 – target not found
        return -1;
    }
}
