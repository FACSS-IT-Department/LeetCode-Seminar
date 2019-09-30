class Solution:

    def dist(self, point: List[int]) -> int:
        return point[0]**2 + point[1]**2

    def kClosest_sort(self, points: List[List[int]], K: int) -> List[List[int]]:
        """
        T(n) = O(nlogn) -- sorted points by distance
        S(n) = O(1) -- no extra space used
        """
        return sorted(points, key=lambda p: self.dist(p))

    def kClosest_randomized_part(self, points: List[List[int]], K: int) -> List[List[int]]:
        """
        T(n) = O(n) -- linear time
        S(n) = O(n) -- size of recursion stack in worst case
        """
        if len(points) <= K:
            return points

        def sort(l: int, r: int, K: int):
            if l >= r:
                return None
            pivot = random.randint(l, r)
            points[l], points[pivot] = points[pivot], points[r]

            mid = partition(l, r)
            if K < mid-l+1:
                sort(l, mid-1, K)
            elif K > mid-l+1:
                sort(mid+1, r, K - (mid-l+1))

        def partition(l: int, r: int) -> int:
            pivot =  l
            pivot_dist = self.dist(points[pivot])
            l += 1
            while True:
                while l < r and self.dist(points[l]) < pivot_dist:
                    l += 1
                while l <= r and self.dist(points[r]) >= pivot_dist:
                    r -= 1
                if l >= r:
                    break
                points[l], points[r] = points[r], points[l]
            points[pivot],  points[r] = points[r], points[pivot]
            return r

        sort(0, len(points)-1, K)
        return points[:K]

