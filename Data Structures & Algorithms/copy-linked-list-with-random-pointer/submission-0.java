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
        Node curr = head;
        Map<Node, Node> map = new HashMap<>();

        while(curr != null){
            Node node = new Node(curr.val);
            map.put(curr, node);
            curr = curr.next;
        }

        curr = head;
        Node temp = map.get(head);
        Node dummy = new Node(0);
        dummy.next = temp;

        while(temp != null && curr != null){
            temp.next = map.get(curr.next);
            temp.random = map.get(curr.random);
            temp = temp.next;
            curr = curr.next;
        }

        return dummy.next;
    }
}
