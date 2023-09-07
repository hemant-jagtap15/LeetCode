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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode ans[] = new ListNode[k];
        ListNode temp = head;
        int size = 0;
        while(temp != null) {
            temp = temp.next;
            size++;
        }

        temp = head;
        ListNode temp2 = null;
        int tempSize = size / k;
        int rem = size % k;
        int x = 0;
        while(rem != 0) {
            for(int i = 0; i < tempSize; i++) {
                temp = temp.next;
            }
            temp2 = temp.next;
            temp.next = null;
            ans[x++] = head;
        
            head = temp2;
            temp2 = null;
            temp = head;
            rem--;
        }

        while(head != null) {
            for(int i = 0; i < tempSize-1; i++) {
                temp = temp.next;
            }
            temp2 = temp.next;
            temp.next = null;
            ans[x++] = head;

            head = temp2;
            temp2 = null;
            temp = head;
        }

        return ans;
    }
}