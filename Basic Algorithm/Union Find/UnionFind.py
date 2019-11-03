"""
Union find/disjoint set
"""

class UnionFind:
    def __init__(self, N: int) -> None:
        self.par = [i for i in range(N)] # [0, 1, 2, 3, ..., N-1]
        self.ranks = [0]*N # [0, 0, 0,..., 0] length = N

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
