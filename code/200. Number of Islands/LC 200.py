class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        h = len(grid)
        
        if h <= 0: return 0
        l = len(grid[0])
        if l <= 0: return 0
        ans = 0
        for y in range(h):
            for x in range(l):
                if grid[y][x] == '1':
                    ans += 1
                    self.killislands(grid, x, y, l, h)
        return ans
                    
    def killislands(self, grid, x, y, l, h):
        if x < 0 or y < 0 or x >= l or y >= h or grid[y][x] == '0':
            return

        grid[y][x] = '0'
        self.killislands(grid, x+1, y, l, h)
        self.killislands(grid, x-1, y, l, h)
        self.killislands(grid, x, y+1, l, h)
        self.killislands(grid, x, y-1, l, h)