class Solution {
    public int maxProfit(int[] prices) {
        // initialize maxProfit to zero – implies no transaction
        // initialize left = 0 and right = l+1 pointer
        int maxProfit = 0;
        int left = 0, right = left+1;

        // while: r is not out of bound – r < array.length
        //// if: price[right] < price[left], update pointers: l = r, r=l+1
        //// else: update maxProfit if appropriate
        while (right < prices.length) {
            int profit = prices[right] - prices[left];

            if (profit < 0) {
                left = right;
                right = left+1;
            }
            else {
                maxProfit = Math.max(maxProfit, profit);
                right++;
            }
                
        }

        // return maxProfit
        return maxProfit;
    }
}
