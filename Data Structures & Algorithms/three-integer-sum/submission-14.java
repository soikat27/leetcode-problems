class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort the input array
        // initialize empty output array
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();

        // loop: iterate index 0 through nums.length-3. For each num at the index:
        //// if: nums[i] == nums[i-1], skip to next, watch for i=0
        //// initialize left = index+1 and right pointers = last
        //// while: l < r
        ////// calculate the sume
        ////// if: sum equals zero, push it to output array, update both pointers until no duplicates
        ////// else if: sum < zero, increment the left until no duplicates
        ////// else: decrement the right until no duplicates
        for (int i = 0; i < nums.length-1; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;

            int left = i+1;
            int right = nums.length-1;

            while (left < right) {
                int sum = nums[i]+nums[left]+nums[right];
                if (sum == 0) {
                    ArrayList<Integer> triplet = new ArrayList<>(List.of(nums[i], nums[left], nums[right]));
                    output.add(triplet);

                    left++;
                    while (left < right && nums[left] == nums[left-1])
                        left++;

                    right--;
                    while (right > left && nums[right] == nums[right+1])
                        right--;
                     
                }
                else if (sum < 0) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }

        // return the output array
        return output;
    }
}
