"""
Sort a linked list using insertion sort.
"""

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    # @param head, a ListNode
    # @return a ListNode
    def insertionSortList(self, head):
        if not head or not head.next:
            return head

        #create a pseudo beforehead
        pseudo_head = ListNode(0)
        pseudo_head.next = head
        before_curr = head
        while before_curr.next:
            # avoid worst case
            if before_curr.val <= before_curr.next.val:
                before_curr = before_curr.next
                continue

            # seek position to insert
            before_insert = pseudo_head
            while before_insert.next.val < before_curr.next.val:
                before_insert = before_insert.next
            temp_curr = before_curr.next
            before_curr.next = temp_curr.next
            temp_curr.next = before_insert.next
            before_insert.next = temp_curr

        return pseudo_head.next
