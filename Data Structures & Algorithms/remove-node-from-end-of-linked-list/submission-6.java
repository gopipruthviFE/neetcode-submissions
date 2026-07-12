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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        for(int i=0;i<n;i++){
            curr = curr.next;
        }

        while(curr != null){
            curr = curr.next;
            prev = prev.next;
        }

        ListNode nthNode = prev.next;
        prev.next = prev.next.next;
        nthNode.next = null;

        return dummy.next;
    }

    // Time : O(n)
    // Space : O(1)
}
