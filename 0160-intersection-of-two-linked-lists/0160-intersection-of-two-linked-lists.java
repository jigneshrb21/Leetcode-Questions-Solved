/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int cnt1 = 0;
        int cnt2 = 0;
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        while(temp1 != null){
            cnt1++;
            temp1 = temp1.next;
        }
        while(temp2 != null){
            cnt2++;
            temp2 = temp2.next;
        }
        temp1 = headA;
        temp2 = headB;
        int diff = cnt1 - cnt2;
        if(diff < 0){
            while(diff != 0){
                temp2 = temp2.next;
                diff++;
            }
        }
        else{
            while(diff != 0){
                temp1 = temp1.next;
                diff--;
            }
        }
        while(temp1 != null){
            if(temp1 == temp2) return temp1;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return null;
    }
}