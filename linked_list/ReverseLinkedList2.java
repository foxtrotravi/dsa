/**
 * Link: https://leetcode.com/problems/reverse-linked-list-ii/
 * Date: 23rd Nov 2021
 * Code #1
*/

import java.util.*;

class ReverseLinkedList2 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        while(t-- > 0) {
            int n = kb.nextInt();

            ListNode head = null, tail = null;

            for (int i = 0; i < n; i++) {
                ListNode temp = new ListNode(kb.nextInt());
                if (head == null) {
                    head = temp;
                    tail = temp;
                } else {
                    tail.next = temp;
                    tail = tail.next;
                }
            }

            int left = kb.nextInt();
            int right = kb.nextInt();

            Solution s = new Solution();
            ListNode res = s.reverseBetween(head, left, right);
            ListNode temp = res;

            StringBuilder sb = new StringBuilder();
            while(temp != null) {
                sb.append(temp.val + " ");
                temp = temp.next;
            }

            System.out.println(sb.toString());
        }
        kb.close();
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if (head == null || head.next == null || left == right) return head;
        
        ListNode start = head, curr = head, prev = null;
        
        int i = 1;
        while (i < left) {
            prev = start;
            start = start.next;
            curr = curr.next;
            i++;
        }
        
        ListNode rev = null;
        
        while (i < right) {
            ListNode next = curr.next;
            curr.next = rev;
            rev = curr;
            curr = next;
            i++;
        }
        
        ListNode tail = curr.next;
        curr.next = rev;
        rev = curr;
        
        if (prev != null) {
            prev.next = curr;
        }
        
        start.next = tail;
        
        return (left > 1) ? head : rev;
    }
}