class Solution {
    public int longestConsecutive(int[] nums) {
        // build a set from the input nums
        // initialize longestStreak to zero
        HashSet<Integer> lookup = new HashSet<>();
        for (int num : nums) {
            lookup.add(num);
        }
        int longestStreak = 0;
        
        // loop: iterate over the nums array. For each num:
        //// if: num has a prev value?, continue. Else:
        //// initialize streak to 1
        //// initialize curNext = 1+num
        //// while: curNext in set, increment next and streak
        //// if: streak > longest streak, update longest streak
        for (int num : nums) {
            if (lookup.contains(num-1))
                continue;
            
            int streak = 1;
            int next = num+1;
            while (lookup.contains(next)) {
                streak++;
                next++;
            }

            if (streak > longestStreak)
                longestStreak = streak;
        }

        // return longest streak
        return longestStreak;
    }
}
