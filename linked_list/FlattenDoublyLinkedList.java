/**
 * Link: https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 * Date: 24th Nov 2021
 * Code #1
*/

import java.util.*;

class FlattenDoublyLinkedList {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        // Somehow take input in Doubly linkedlist with child
    }
}

class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;
        
        Node curr = head;
        Node res = null;
        Node temp = head;
        
        Stack<Node> stack = new Stack<>();
        
        while(curr != null) {
            if (res == null) {
                res = curr;
            } else {
                temp.next = curr;
                curr.prev = temp;
                temp = temp.next;
            }
            
            if (curr.child != null) {
                if (curr.next != null) {
                    stack.push(curr.next);
                }
                Node node = curr.child;
                curr.next = node;
                node.prev = curr;
                curr.child = null;    
            }
            
            curr = curr.next;
            
            if (curr != null && curr.next == null && curr.child == null && !stack.empty()) {
                Node node = stack.pop();
                node.prev = curr;
                curr.next = node;
            }
        }
        
        return res;
    }
}