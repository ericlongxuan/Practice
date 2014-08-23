"""
Implement int sqrt(int x).

Compute and return the square root of x.
"""

class Solution:
    # @param x, an integer
    # @return an integer
    def sqrt(self, x):
        lower = 0
        upper = (x+1)/2

        while True:
            mid = (lower + upper) / 2
            if mid ** 2 <= x and (mid+1) ** 2 >x:
                break
            elif mid ** 2 > x:
                upper = mid
            else:
                lower = mid + 1
        return mid
