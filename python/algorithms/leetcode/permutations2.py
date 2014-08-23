"""
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
"""


class Solution:
    # @param num, a list of integer
    # @return a list of lists of integers
    def permuteUnique(self, num):
        if not num:
            return []
        return self.permute_rec(num)

    def permute_rec(self, num):
        if 1 == len(num):
            return [num]

        result = []
        num_set = set()
        for i in num:
            if i in num_set:
                continue

            num_set.add(i)
            num_copy = num[:]
            num_copy.remove(i)
            child_permute = self.permute_rec(num_copy)
            for l in child_permute:
                result.append([i] + l)
        return result
