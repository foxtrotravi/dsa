/**
 * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Date: 20th Nov 2021
 * Code #1
*/

import java.util.*;

class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        kb.nextLine();
        while(t-- > 0) {
            String s = kb.nextLine();
            Solution solution = new Solution();
            System.out.println(solution.lengthOfLongestSubstring(s));
        }
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        
        if (s.length() == 2 && s.charAt(0) == s.charAt(1)) return 1;
        
        int left = 0, right = 0;
        int max = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        
        while (right < s.length()) {
            if (!map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), right);
                right++;
                
            } else {
                // System.out.println(map);
                if (left <= map.get(s.charAt(right))) {
                    
                    left = map.get(s.charAt(right)) + 1;
                    map.put(s.charAt(right), right);
                }
                map.put(s.charAt(right), right);
                right++;
            }
            
            // System.out.println(left + ", " + right);
            // System.out.println(s.substring(left, right));
            
            max = Math.max(max, (right - left));
        }
        
        return max;
        
//         if (s.length() == 0) return 0;
        
//         int ans = 0;
//         for(int i = 0; i < s.length(); i++) {
//             for(int j = i+1; j < s.length(); j++) {
//                 String temp = s.substring(i, j+1);
                
//                 if (unique(temp)) {
//                     ans = Math.max(ans, temp.length());
//                 }
//             }
//         }
        
//         return ans;
    }
    
    public boolean unique(String s) {
        Set<Character> set = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                return false;
            } else {
                set.add(s.charAt(i));
            }
        }
        
        return true;
    }
}