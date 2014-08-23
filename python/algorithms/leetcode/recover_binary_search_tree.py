"""
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
"""



# Definition for a  binary tree node
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # @param root, a tree node
    # @return a tree node
    def recoverTree(self, root):
        self.in_order(root)

        print("______")
        self.reverse_in_order(root)

        print("______")
        print(self.left_max.val)
        print(self.right_min.val)

        if self.bad_1 and self.bad_2:
            temp = self.bad_1.val
            self.bad_1.val = self.bad_2.val
            self.bad_2.val = temp
        return root

    def __init__(self):
        self.seq = []
        self.left_max = None
        self.right_min = None
        self.bad_1 = None
        self.bad_2 = None

    def in_order(self, node):
        if not node:
            return

        self.in_order(node.left)
        if not self.left_max:
            self.left_max = node

        print("%d,  %d" % (node.val, self.left_max.val))

        #suppose to be increasing order
        if node.val < self.left_max.val:
            self.bad_1 = self.left_max
            print("!!!")
            return

        if not self.bad_1:
            self.left_max = node
            self.in_order(node.right)

    def reverse_in_order(self, node):
        if not node:
            return

        self.reverse_in_order(node.right)
        if not self.right_min:
            self.right_min = node

        print("%d,  %d" % (node.val, self.right_min.val))

        #suppose to be decreasing order
        if node.val > self.right_min.val:
            self.bad_2 = self.right_min
            print("!!!")
            return

        if not self.bad_2:
            self.right_min = node
            self.reverse_in_order(node.left)
