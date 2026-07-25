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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode temp = head;
        ListNode front = null;
        ListNode back = null;
        ListNode newHead = head;
        ListNode prev = null;
        int n = 0;

        while (temp != null) {
            n++;

            if (n == k) {
                front = temp.next;
                temp.next = null;

                ListNode rev = reverse(head);

                if (prev == null) {
                    newHead = rev;
                } else {
                    prev.next = rev;
                }

                head.next = front;
                prev = head;

                head = front;
                temp = front;
                n = 0;
            } else {
                temp = temp.next;
            }
        }

        return newHead;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}