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
    public ListNode oddEvenList(ListNode head) {

    ListNode oddDummy = new ListNode(0);
    ListNode evenDummy = new ListNode(0);

    ListNode odd = oddDummy;
    ListNode even = evenDummy;

    int length = 1;

    while (head != null) {

        ListNode node = new ListNode(head.val);

        if (length % 2 == 0) {
            even.next = node;
            even = even.next;
        } 
        else {
            odd.next = node;
            odd = odd.next;
        }

        length++;
        head = head.next;
    }

    odd.next = evenDummy.next;

    return oddDummy.next;
}
}    