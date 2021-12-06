/**
 * Link: https://leetcode.com/problems/valid-parentheses/submissions/
 * Date: 06 Dec 2021
 * Code #1
*/

import java.util.*;

class ValidParentheses {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        kb.nextLine();
        while(t-- > 0) {
            String str = kb.nextLine();
            Solution s = new Solution();
            System.out.println(s.isValid(str));
        }
        kb.close();
    }
}

class Solution {
    public boolean isValid(String s) {
        if (s.length() == 1 || s.length() % 2 != 0) return false;
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            switch(ch) {
                case '(':
                    stack.push(')');
                break;
                case '[':
                    stack.push(']');
                break;
                case '{':
                    stack.push('}');
                break;
                case ')': case ']': case '}':
                    if (stack.empty()) return false;
                    
                    if (stack.pop() != ch) return false;
                break;
            }
        }
        
        return stack.empty() ? true : false;
    }
}