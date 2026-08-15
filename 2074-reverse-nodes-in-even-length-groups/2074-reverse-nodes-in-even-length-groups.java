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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int l = length(head);

    for(int k = 1; k <= l; k++){

        

            int start = k * (k - 1) / 2 + 1;
            int end = Math.min(k * (k + 1) / 2, l);

            // No nodes left for this group
            if(start > l){
                break;
            }

            int actualLength = end - start + 1;

            if(actualLength % 2 == 0){
                head = reverseBetween(head, start, end);
            }
        
    }

    return head;
}
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        // skip the first left-1 nodes
        ListNode current = head;
        ListNode prev = null;
        for (int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }

        ListNode last = prev;
        ListNode newEnd = current;

        // reverse between left and right
        ListNode next = current.next;
        for (int i = 0; current != null && i < right - left + 1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = current;
        return head;
    
    }
    public int length(ListNode head){
        int length =0; 
        while(head != null){
            length++;
            head = head.next;
        }
        return length;
    }
}