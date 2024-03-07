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
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int counter = 1;

        while(fast.next != null) {
            fast = fast.next;
            counter++;
        }

        fast = head;

        while(fast.next !=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return counter%2== 0 ? slow.next : slow;
        
    }
}
