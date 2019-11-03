class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        """
        T(n) = c + n^2*log(n) + n = O(n^2*log(n))
        S(n) = 2n = O(n)
        """
        # O(1)
        if M is None or len(M) == 0 or len(M[0]) == 0 or len(M) != len(M[0]): return 0
        N = len(M) # N*N
        self.par = [i for i in range(N)] # [0, ..., N-1]
        self.rank = [0]*N # [0,...,0]

        # O(n^2*logn)
        for i in range(N):
            for j in range(N):
                if M[i][j] == 1 and i != j:
                    self.union(i, j) # O(log n)

        ans = 0

        # O(N)
        # par = [0, 1, 2] in the example of 0th, 1st, 2nd students
        # par = [0, 0, 0]
        for i in (len(self.par)):
            if i == self.par[i]:
                ans = ans + 1
        return ans

    def find(self, x: int) -> int:
        if x != self.par[x]:
            self.par[x] = self.find(self.par[x])
        return self.par[x] # root of the set

    def union(self, x: int, y: int) -> bool:
        xroot = self.find(x)
        yroot = self.find(y)
        if xroot == yroot:
            return False
        # xroot is not yroot
        if self.rank[xroot] > self.rank[yroot]:
            self.par[yroot] = xroot
        elif self.rank[xroot] < self.rank[yroot]:
            self.par[xroot] = yroot
        else: # rank is the same
            self.par[yroot] = xroot
            self.rank[xroot] = self.rank[xroot] + 1
        return True # union is successful
