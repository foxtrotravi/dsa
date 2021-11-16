/**
 * Link: https://leetcode.com/problems/two-sum/
 * Date: 16th Nov 2021
 * Code #1
 * 
 * ============================================================
 * Approach
 * ============================================================
 * 
 * Step 1: Verify the constraints
 *      - Are all numbers positives or there can be negatives
 *      - Are there duplicate numbers in the array
 *      - Will there always be a solution available
 *      - What do we return if there is no solution
 *      - Can there be multiple pairs that add up to the target
 * 
 * Step 2: Write some test cases
 *      Input               Target  Output
 *      - [1, 3, 7, 9, 2]   11      [3, 4]
 *      - [1, 3, 7, 9, 2]   25      null
 *      - []                1       null
 *      - [5]               5       null
 *      - [1, 6]            7       [0, 1]
 * 
 * Step 3: Figure out a solution without code
 * Step 4: Write out our solution in code (Brute Force)
 * Step 5: Double check for errors
 * 
 * ============================================================
 * Analyzing Space & Time Complexity
 * ============================================================
 * 
 * Polynomial Complexity
 * ---------------------
 * O(logn) - Logarithmic
 * O(n) - Linear
 * O(nlogn) - Linearithmic
 * O(n^2) - Quadratic
 * O(n^3) - Cubic
 * 
 * Exponential Complexity
 * ----------------------
 * 
 * O(2^n) - Exponential
 * O(n!) - Factorial
 * O(n^n) - Exponential
 * 
 * Step 6: Can we optimize our solution
*/

import java.util.*;

class TwoSum {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        while(t-- > 0) {
            int n = kb.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = kb.nextInt();
            }

            int target = kb.nextInt();

            Solution s = new Solution();
            int[] result = s.twoSum(arr, target);
            System.out.println(Arrays.toString(result));
        }
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // return bruteForce(nums, target);

        // Time Complexity: O(n)
        // Space Complexity: O(n)
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return new int[2];
    }

    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public int[] bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}