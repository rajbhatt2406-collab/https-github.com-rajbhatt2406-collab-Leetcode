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
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode past = dummy;
        ListNode current = head;

        while (current != null) {

            // Duplicate found
            if (current.next != null && current.val == current.next.val) {

                // Skip all nodes having the same value
                while (current.next != null &&
                       current.val == current.next.val) {
                    current = current.next;
                }

                // Remove the complete duplicate group
                past.next = current.next;

                // Move current
                current = current.next;

            } else {
                // No duplicate
                past = current;
                current = current.next;
            }
        }

        return dummy.next;
    }
}