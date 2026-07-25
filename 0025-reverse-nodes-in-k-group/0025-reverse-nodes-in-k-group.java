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
        ListNode kth = null;
        while(true){
            kth = getkth(temp, k - 1);   
            if(kth == null){
               if(back != null) back.next = temp;
                break;
            }  
            front = kth.next;
            kth.next = null;
            kth = reverse(temp);
            if(temp == head){
                head = kth;
            }
            else{
                back.next = kth;
            }
            back = temp;
            temp = front;   
        }
        return head;
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
    private ListNode getkth(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
            
        }
        return curr;
    }
}