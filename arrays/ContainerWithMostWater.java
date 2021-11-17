/**
 * Link: https://leetcode.com/problems/container-with-most-water/
 * Date: 17th Nov 2021
 * Code #1
 * 
 * ============================================================
 * Approach
 * ============================================================
 * 
 * Step 1: Verify the constraints
 *      - Does the thickness of the line affect the area? No
 *      - Do the left & right sides of the graph count as walls? No
 *      - Does a higher line inside our container affect the area? No
 * 
 * Step 2: Write some test cases
 *      - []
 *      - [1, 2, 5]
 *      - [6, 2, 1, 4, 3, 1, 9]
 * 
 * Step 3: Figure out a solution without code
 * Step 4: Write out our solution in code (Brute Force)
 * Step 5: Double check for errors
 * 
 * ============================================================
 * Analyzing Space & Time Complexity
 * ============================================================
 * Brute force solution
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 * 
 * Optimized solution
 * Time complexity: O(n)
 * Space complexity: O(n)
*/

import java.util.*;

class ContainerWithMostWater {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        while(t-- > 0) {
            int n = kb.nextInt();
            int[] heights = new int[n];

            for (int i = 0; i < n; i++) {
                heights[i] = kb.nextInt();
            }
            Solution s = new Solution();
            System.out.println(s.maxArea(heights));
        }
    }
}

class Solution {
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int maxArea(int[] height) {
        // return bruteForce(height);
        
        int max = 0;
        int i = 0, j = height.length - 1;
        
        while (i < j) {
            int waterTrapped = Math.min(height[i], height[j]) * (j - i);
            max = Math.max(max, waterTrapped);
            
            // changing smaller value because waterTrapped depends on
            // the value which is smaller
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        
        return max;
    }
    
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public int bruteForce(int[] height) {
        int max = 0;
        
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                int waterTrapped = Math.min(height[i], height[j]) * (j - i);
                max = Math.max(waterTrapped, max);
            }
        }
        
        return max;
    }
}