class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # initialize maxProfit to zero – assumes no transaction
        # initialize left=0 and right=1 pointers
        maxProfit = 0
        left = 0
        right = 1

        # while: right is not out of bound – right < list.length
        ## calculate profit
        ## if: profit < 0, update pointers: left = right, right = left+1
        ## else: update maxProfit and increment right pointer
        while right < len(prices):
            profit = prices[right] - prices[left]
            if profit < 0:
                left = right
                right = left+1
            else:
                maxProfit = max(maxProfit, profit)
                right += 1

        # return maxProfit
        return maxProfit