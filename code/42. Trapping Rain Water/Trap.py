class Solution:

    def trap_BF(self, height: List[int]) -> int:
        """
        T(n) = O(n^2) -- n*(n/2+n/2)
        S(n) = O(1) -- no extra sapce used
        ----------
        Note: TLE in python, accepted in Java. See TrapBF.java
        """
        if len(height) <= 1:
            return 0
        ans = 0
        for i in range(len(height)):
            max_l, max_r = 0
            for j in range(i, -1, -1):
                max_l = max(max_l, height[j])
            for k in range(i, len(height)):
                max_r = max(max_r, height[k])
            ans += min(max_l, max_r) - height[i]
        return ans

    def trap_DP(self, height: List[int]) -> int:
        """
        T(n) = O(n) = 3n -- 3 passes
        S(n) = O(n) = 2n -- memoized results in two arrays of n
        """
        if len(height) <= 1:
            return 0

        ans = 0
        n = len(height)

        max_l = [0]*n
        max_l[0] = height[0]
        for i in range(1, n):
           max_l[i] = max(max_l[i-1], height[i])

        max_r = [0]*n
        max_r[n-1] = height[n-1]
        for i in range(n-2, -1, -1):
            max_r[i] = max(max_r[i+1], height[i])

        for i in range(n):
            ans += min(max_l[i], max_r[i]) - height[i]
        return ans

    def trap_PTR(self, height: List[int]) -> int:
        """
        T(n) = O(n) = n -- one pass
        S(n) = O(1) -- no extra var used
        """
        if len(height) <= 1:
            return 0
        ans = 0
        l = 0
        r = len(height) - 1
        max_l = max_r = 0
        while l < r:
            if height[l] < height[r]:
                if max_l <= height[l]:
                    max_l = height[l]
                else:
                    ans += max_l - height[l]
                l += 1
            else:
                if max_r <= height[r]:
                    max_r = height[r]
                else:
                    ans += max_r - height[r]
                r -= 1
        return ans
