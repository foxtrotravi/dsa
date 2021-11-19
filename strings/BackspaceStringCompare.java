/**
 * Link: https://leetcode.com/problems/backspace-string-compare/
 * Date: 19th Nov 2021
 * Code #1
*/

import java.util.*;

class BackspaceStringCompare {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int test = kb.nextInt();
        kb.nextLine();
        while(test-- > 0) {
            String s = kb.nextLine();
            String t = kb.nextLine();
            Solution solution = new Solution();
            System.out.println(solution.backspaceCompare(s, t));
        }
    }
}

class Solution {
    public boolean backspaceCompare(String s, String t) {
        s = modifiedString(s);
        t = modifiedString(t);
        
        return s.equals(t);
    }
    
    public String modifiedString(String s) {
        int i = s.length() - 1;
        
        int skip = 0;
        StringBuilder sb = new StringBuilder();
        
        while (i >= 0) {
            
            if (s.charAt(i) != '#') {
                if (skip > 0) {
                    skip--;
                    i--;
                    continue;
                }
                sb.append(s.charAt(i));
            } else {
                skip++;
            }
            i--;
        }
        
        return sb.toString();
    }
}