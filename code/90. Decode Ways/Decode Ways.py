class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s: return
        
        length = len(s)
        
        dp = [1] + [0] * length
        
        for i in range(1, length + 1):
            if s[i-1] != '0':
                dp[i] += dp[i-1]
                
            if i>= 2 and 10 <= int(s[i-2:i]) <= 26:
                dp[i] += dp[i-2]
        return dp[length]