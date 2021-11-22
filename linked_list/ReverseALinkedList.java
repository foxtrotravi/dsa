/**
 * Link: https://leetcode.com/problems/reverse-linked-list/
 * Date: 22nd Nov, 2021
 * Code #1
*/

import java.util.*;

class ReverseALinkedList {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        while(t-- > 0) {
            int n = kb.nextInt();
            
            ListNode head = null, tail = null;

            if (n != 0) {
                head = new ListNode(kb.nextInt());
                tail = head;
            }

            while(n-- > 1) {
                tail.next = new ListNode(kb.nextInt());

                if (n > 1)
                tail = tail.next;
            }
            
            Solution s = new Solution();
            
            ListNode res = s.reverseList(head);
            System.out.println((res == null) ? "" : res.toString());
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    
    ListNode() {}
    
    ListNode(int val) { 
        this.val = val; 
    }

    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; 
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode head = this;

        while(head != null) {
            sb.append(head.val + " ");
            head = head.next;
        }

        return sb.toString();
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode curr = head, prev = null;
        
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}