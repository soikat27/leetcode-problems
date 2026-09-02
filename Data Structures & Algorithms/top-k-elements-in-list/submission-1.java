class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // initiate a freq. map
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // loop: iterate over the nums array.
        // populate the freq. map
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }

        // initiate freq. bucket array of lists; size: 1+length of nums array
        // loop: each entry is initialized with an empty arraylist
        List<Integer>[] bucket = new List[nums.length+1];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<Integer>();
        }

        // loop: iterate over the entries
        // populate the bucket so that (index: freq, value: nums)
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int index = entry.getValue();
            int num = entry.getKey();

            bucket[index].add(num);
        }

        // initiate return array (size=k)
        // declare n: current index to fill
        int[] topKArray = new int[k];
        int n = 0;

        // loop: iterate (from the end) over the bucket array until (valid index and n<k)
        //// loop: iterate over the list
        //// if: n == k, break out of the loop
        //// put the value in the bucket indexed=n
        for (int i = bucket.length-1; i >= 0 && n < k; i--) {
            List<Integer> list = bucket[i];

            for (int num : list) {
                if (n == k)
                    break;
                
                topKArray[n++] = num;
            }
        }

        return topKArray;
    }
}
