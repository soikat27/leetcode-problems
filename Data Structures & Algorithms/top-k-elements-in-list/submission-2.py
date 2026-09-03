class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # initiate empty freq. map
        freqMap = {}
        
        # loop: iterate over the nums array
        # put to the freq. map as (key: num, value: freq.)
        for num in nums:
            freqMap[num] = freqMap.get(num, 0)+1

        # initiate a bucket: array of empty lists
        bucketArray = [[] for _ in range(len(nums)+1)]

        # loop: iterate over the freq. map entries
        # append the num to the list at the (index: value)
        for key, value in freqMap.items():
            bucketArray[value].append(key)

        # initiate empty return list
        topKArray = []

        # loop: iterate over the bucket (from end)
        ## loop: iterate over the list
        ## append the num
        ## if: topKArray == k, return
        ## else: append to the result list
        for i in range(len(bucketArray)-1, 0, -1):
            for num in bucketArray[i]:
                topKArray.append(num)
                if len(topKArray) == k:
                    return topKArray
        