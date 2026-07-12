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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        for(int i=0;i<n;i++){
            pq.offer(lists[i]);
        }

        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            curr.next = node;
            if(node.next != null){
                pq.offer(node.next);
            }
            curr = curr.next;
        }

        return dummy.next;
    }

    // Time : O(n) + O(Nlogn) --> N is nodes
    // Space : O(Nlogn)
}
