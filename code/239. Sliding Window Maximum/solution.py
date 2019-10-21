class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        if nums == [] or k == 1:
            return nums
        
        deque = [0]
        result = []
        
        for i in range(1, len(nums)):
            while deque != [] and nums[deque[-1]] <= nums[i]:
                del deque[-1]
            deque.append(i)
            if deque[0] < i - k + 1:
                del deque[0]
            if i >= k - 1:
                result.append(deque[0])
        
        result = [nums[i] for i in result]
            
        return result
