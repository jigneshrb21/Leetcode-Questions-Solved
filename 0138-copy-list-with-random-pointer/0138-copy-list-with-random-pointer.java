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
        Node dummy = new Node(-1);
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        while(temp != null){
            Node newnode = new Node(temp.val);
            map.put(temp, newnode);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            Node dum = map.get(temp);
            dum.next = map.get(temp.next);
            dum.random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }
}