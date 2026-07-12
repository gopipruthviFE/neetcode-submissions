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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       ListNode dummy = new ListNode();

       ListNode curr1 = list1;
       ListNode curr2 = list2;
       ListNode curr = dummy;

       while(curr1 != null && curr2 != null){
            if(curr1.val <= curr2.val){
                ListNode node = new ListNode();
                node.val = curr1.val;
                curr.next = node;
                curr = curr.next;
                curr1 = curr1.next;
            }else{
                ListNode node = new ListNode();
                node.val = curr2.val;
                curr.next = node;
                curr = curr.next;
                curr2 = curr2.next;
            }
       }

       while(curr1 != null){
            ListNode node = new ListNode();
            node.val = curr1.val;
            curr.next = node;
            curr = curr.next;
            curr1 = curr1.next;
       }
       while(curr2 != null){
        ListNode node = new ListNode();
        node.val = curr2.val;
        curr.next = node;
        curr2 = curr2.next;
        curr = curr.next;
       }

       return dummy.next;
    }

    // Time : O(m + n)
    // Space : O(m + n)
}