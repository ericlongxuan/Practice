"""
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
"""

#Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # @param root, a tree node
    # @return an integer
    def minDepth(self, root):
        if root is None:
            return 0
        self.q.append((root, 1))
        return self.bfs()


    def __init__(self):
        self.q = []

    def bfs(self):
        while self.q:
            f = self.q.pop(0)
            if self.is_leaf(f[0]):
                return f[1]
            if f[0].left:
                self.q.append((f[0].left, f[1]+1))
            if f[0].right:
                self.q.append((f[0].right, f[1]+1))

    def is_leaf(self, node):
        if node.left is None and node.right is None:
            return True
        return False
