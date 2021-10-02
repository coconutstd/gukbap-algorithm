# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:

    def isPalindrome(self, head) -> bool:
        arr = []
        while head.next:
            arr.append(head.val)
            head = head.next
        if head.val:
            arr.append(head.val)

        return arr[:] == arr[::-1]