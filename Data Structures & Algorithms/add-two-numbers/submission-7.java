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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        int carry = 0;

        while(curr1 != null && curr2 != null){
            int val = (curr1.val + curr2.val) + carry;
            if(val >= 10){
                carry = 1;
                val = val % 10;
            }else{
                carry = 0;
            } 
            ListNode node = new ListNode(val);

            curr.next = node;
            curr = curr.next;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        while(curr1 != null){
            int val = (curr1.val) % 10 + carry;
            if(val >= 10){
                carry = 1;
                val = val % 10;
            }else{
                carry = 0;
            } 
            ListNode node = new ListNode(val);

            curr.next = node;
            curr = curr.next;
            curr1 = curr1.next;
        }
        while(curr2 != null){
            int val = (curr2.val) % 10 + carry;
            if(val >= 10){
                carry = 1;
                val = val % 10;
            }else{
                carry = 0;
            } 
            ListNode node = new ListNode(val);

            curr.next = node;
            curr = curr.next;
            curr2 = curr2.next;
        }

        if(carry == 1){
            int val = carry;
            ListNode node = new ListNode(val);

            curr.next = node;
            curr = curr.next;
        }

        return dummy.next;
    }

    // Time : O(n)
}
