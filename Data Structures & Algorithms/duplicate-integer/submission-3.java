class Solution {
    public boolean hasDuplicate(int[] nums) {
        // initiate a lookup hashset
        HashSet<Integer> lookup = new HashSet<>();
        
        // iterate over the array
        // for each item: if it's contained in the lookup hashset: return true; otherwise: push it to the lookup set
        // if exits the loop: return false
        for (int num : nums) {
            if (lookup.contains(num))
                return true;
            
            lookup.add(num);
        }
        return false;
    }
}