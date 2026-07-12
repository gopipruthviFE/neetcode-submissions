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
        ListNode curr = dummy;

        ListNode point1 = list1;
        ListNode point2 = list2;

        while(point1 != null && point2 != null){
            if(point1.val <= point2.val){
                curr.next = point1;
                point1 = point1.next;
                curr = curr.next;
            }else{
                curr.next = point2;
                point2 = point2.next;
                curr = curr.next;
            }
        }

        while(point1 != null){
            curr.next = point1;
            point1 = point1.next;
            curr = curr.next;
        }

        while(point2 != null){
            curr.next = point2;
            point2 = point2.next;
            curr = curr.next;
        }

        return dummy.next;
    }
}