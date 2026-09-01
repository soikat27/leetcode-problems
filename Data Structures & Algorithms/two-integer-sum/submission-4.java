class Solution {
    public int[] twoSum(int[] nums, int target) {
        // initiate an empty map
        HashMap<Integer, Integer> seen = new HashMap<>();

        // loop: iterate over the array through index.
        // if: the diff is in the "seen" map, return the array of indices [x: (retrieved from the map), y: (current index)]
        // otherwise, put (key: num, value: index)
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (seen.containsKey(diff))
                return new int[] {seen.get(diff), i};

            seen.put(nums[i], i);
        }

        return null;
    }
}
