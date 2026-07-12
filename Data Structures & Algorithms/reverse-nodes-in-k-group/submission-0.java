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
        ListNode dummy = new ListNode(0);
        ListNode groupPrev = dummy;
        dummy.next = head;

        while(true){
            ListNode kth = getKth(groupPrev, k);
            if(kth == null){
                break;
            }

            ListNode groupStart = groupPrev.next;
            ListNode nxtGrpStart = kth.next;

            ListNode curr = groupStart;
            ListNode prev = nxtGrpStart;

            while(curr != nxtGrpStart){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            groupPrev.next = kth;
            groupPrev = groupStart;
        }

        return dummy.next;
    }

    public ListNode getKth(ListNode node, int k){
        while(node != null && k > 0){
            node = node.next;
            k--;
        }

        return node;
    }
}
