/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head.next == null) return head;
        ListNode helper = new ListNode(0);
        ListNode curr = head;
        ListNode pre = helper;
        ListNode next = null;
        while(curr != null) {
            next = curr.next;

            while(pre.next != null && pre.next.val < curr.val) {
                pre = pre.next;
            }

            curr.next = pre.next;
            pre.next = curr;
            pre = helper;
            curr = next;
        }
        return helper.next;
    }
}
