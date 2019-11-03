class Solution(object):
    def getPermutation(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        list1 = range(1, n+1)
        
        res = ''
        
        k -= 1
        
        while n > 0:
            n-=1
            d, k = divmod(k, math.factorial(n))
            res += str(list1[d])
            list1.remove(list1[d])
            
        return res