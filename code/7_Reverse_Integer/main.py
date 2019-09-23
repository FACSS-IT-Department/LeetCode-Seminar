class Solution:
    @staticmethod
    def reverse(x: int) -> int:
        if x < 0:
            sign = -1
            x = -x
        else:
            sign = 1

        reverse_x = 0
        while x > 0:
            reverse_x = reverse_x * 10 + x % 10
            x //= 10

        reverse_x *= sign

        if -(2 ** 31) <= reverse_x < (2 ** 31) - 1:
            return reverse_x
        else:
            return 0


if __name__ == '__main__':
    print(Solution.reverse(123))
    print(Solution.reverse(-123))
    print(Solution.reverse(120))
    print(Solution.reverse(2 ** 31 - 1))
    print(Solution.reverse(-(2 ** 31)))
    print(Solution.reverse(-8463847412))
