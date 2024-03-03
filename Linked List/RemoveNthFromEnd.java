/**
Given the head of a linked list, remove the nth node from the end of the list and return its head. 

Example 1:

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:

Input: head = [1], n = 1
Output: []

Example 3:

Input: head = [1,2], n = 1
Output: [1]

**/


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = head;
        int len = 0;
        while(temp!=null) {
            len++;
            temp = temp.next;
        }

        len-=n;
        temp = dummy;
        
        while(len > 0) {
            len--;
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return dummy.next;

    }
}
