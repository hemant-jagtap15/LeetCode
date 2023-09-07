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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head;
        ListNode prev = null;
        int count = 0;
        while(count < left - 1) {
            prev = curr;
            curr = curr.next;
            count++;
        }
        ListNode start = curr;
        while(count < right-1) {
            curr = curr.next;
            count++;
        }
        ListNode rest = curr.next;
        curr.next = null;
        
        ListNode newHead = reverse(start);
        if(prev != null) {
            prev.next = newHead;
        }
        curr = newHead;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = rest;
        if(left == 1) {
            return newHead;
        } else {
            return head;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}