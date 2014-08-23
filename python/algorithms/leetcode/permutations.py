"""
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
"""


class Solution:
    # @param num, a list of integer
    # @return a list of lists of integers
    def permute(self, num):
        result = []
        if len(num) == 1:
            return [num]

        for i in num:
            num_copy = num[:]
            num_copy.remove(i)

            num_copy_permute = self.permute(num_copy)
            for child_list in num_copy_permute:
                result.append([i]+child_list)
        return result
