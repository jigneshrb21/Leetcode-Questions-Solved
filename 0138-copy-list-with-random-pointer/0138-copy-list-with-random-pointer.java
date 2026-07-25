/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        if(head == null){
            return null;
        }
        if(head.next == null && head.random == null){
            Node dum = new Node(head.val);
            return dum;
        }
        while(temp != null){
            Node dummy = new Node(temp.val);
            dummy.next = temp.next;
            temp.next = dummy;
            temp = temp.next.next;
        }
        temp = head;
        while(temp != null){
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        temp = head;
        Node dum = new Node(-1);
        Node res = dum;
        while(temp != null){
            res.next = temp.next;
            temp.next = temp.next.next;
            res = res.next;
            temp = temp.next;
        }
        return dum.next;
    }
}