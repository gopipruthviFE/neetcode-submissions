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
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;

        while(curr != null){
            Node node = new Node(curr.val);
            map.put(curr, node);
            curr = curr.next;
        }

        Node nHead = map.get(head);
        curr = head;
        Node temp = nHead;

        while(curr != null){
            Node rand = map.get(curr.random);
            Node next = map.get(curr.next);
            temp.next = next;
            temp.random = rand;
            temp = temp.next;
            curr = curr.next;
        }

        return nHead;
    }

    // Time : O(n)
}
