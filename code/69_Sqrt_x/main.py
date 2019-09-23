class Solution:
    @staticmethod
    def mySqrt(x: int) -> int:
        left, right = 0, x
        while left < right:
            mid = (left + right) // 2
            if mid * mid == x:
                return mid
            elif mid * mid < x:
                left = mid + 1
            else:
                right = mid - 1
        if left * left > x:
            left -= 1
        return left


if __name__ == '__main__':
    print(Solution.mySqrt(4))
    print(Solution.mySqrt(8))
    print(Solution.mySqrt(2))
    print(Solution.mySqrt(0))
    print(Solution.mySqrt(1))
    print(Solution.mySqrt(101))

