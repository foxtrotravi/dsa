/**
 * Link: https://leetcode.com/problems/valid-palindrome-ii/
 * Date: 21st Nov 2021
 * Code #1
*/

import java.util.*;

class ValidPalindrome {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        kb.nextLine();
        while(t-- > 0) {
            String s = kb.nextLine();
            Solution solution = new Solution();
            System.out.println(solution.validPalindrome(s));
        }
    }
}

class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        int count = 0;
        
        while (i < j) {
            char l = s.charAt(i);
            char r = s.charAt(j);
            
            if (l != r) {
                if (s.charAt(i+1) != s.charAt(j) && s.charAt(j-1) != s.charAt(i)) {
                    return false;
                } else {
                    count++;
                    if (count > 1) return false;
                    
                    if (s.charAt(i+1) == s.charAt(j) && s.charAt(j-1) == s.charAt(i)) {
                        boolean checkLeft = check(s, i+1, j);
                        boolean checkRight = check(s, i, j-1);
                        return (checkLeft || checkRight);
                    } else if (s.charAt(i+1) == s.charAt(j)) {
                        i++;
                    } else {
                        j--;
                    }
                }
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
    
    boolean check(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}