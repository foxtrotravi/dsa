/**
 * Link: https://leetcode.com/problems/trapping-rain-water/solution/
 * Date: 18th Nov 2021
 * Code #1
*/

import java.util.*;

class TrappingRainwater {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        while(t-- > 0) {
            int n = kb.nextInt();
            int[] height = new int[n];

            for (int i = 0; i < n; i++) {
                height[i] = kb.nextInt();
            }
            Solution s = new Solution();
            System.out.println(s.trap(height));
        }
    }
}

class Solution {
    public int trap(int[] height) {
        // Time complexity: O(n)
        // Space complexity: O(n)
        // waterTrapped = min(maxLeft, maxRight) - currentHeight;
        
        // int[] leftMax = new int[height.length];
        // int[] rightMax = new int[height.length];
        
        // int max = -1;
        // for (int i = 1; i < height.length; i++) {
        //     max = Math.max(max, height[i-1]);
        //     leftMax[i] = max;
        // }
        
        // max = -1;
        // for (int i = height.length - 2; i > 0; i--) {
        //     max = Math.max(max, height[i+1]);
        //     rightMax[i] = max;
        // }
        // rightMax[0] = max;
        
        // int totalWaterTrapped = 0;
        
        // for (int i = 0; i < height.length; i++) {
        //     int waterTrapped = Math.min(leftMax[i], rightMax[i]) - height[i];
        //     if (waterTrapped > 0) {
        //         totalWaterTrapped += waterTrapped;
        //     }
        // }
        
        // return totalWaterTrapped;

        // Time Complexity: O(n)
        // Space Complexity: O(1)

        int maxLeft = 0, maxRight = 0;
        int totalWaterTrapped = 0;
        
        int left = 0, right = height.length - 1;
        
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] > maxLeft) {
                    maxLeft = height[left];
                } else {
                    totalWaterTrapped += (maxLeft - height[left]);
                }
                left++;
            } else {
                if (height[right] > maxRight) {
                    maxRight = height[right];
                } else {
                    totalWaterTrapped += (maxRight - height[right]);
                }
                right--;
            }
        }

        return totalWaterTrapped;
    }
}
