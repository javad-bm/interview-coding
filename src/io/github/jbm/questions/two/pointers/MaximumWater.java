package io.github.jbm.questions.two.pointers;

/**
 * Trapping Rain Water Problem
 * 
 * This is a classic algorithmic problem that asks: Given an array representing heights of bars,
 * how much water can be trapped between the bars after rain?
 * 
 * Problem Description:
 * - Each element in the array represents the height of a bar
 * - Water can only be trapped if there are bars on both sides that are higher than the current position
 * - The amount of water trapped at position i is: min(leftMax, rightMax) - height[i]
 * - If this value is negative, no water is trapped at that position
 * 
 * 
 * Time Complexity: O(n) - single pass through the array
 * Space Complexity: O(1) - only using a few variables
 */

public class MaximumWater {
    
    /**
     * Optimized solution using two pointers approach
     * 
     * The key insight is that the water trapped at any position depends on the minimum
     * of the maximum height to the left and the maximum height to the right.
     * 
     * Instead of calculating leftMax and rightMax for each position separately,
     * we use two pointers and maintain the maximum heights seen so far from both ends.
     * 
     * @param height array representing bar heights
     * @return total amount of water that can be trapped
     */
    public static int findMaxCapacity(int[] height) {
        if (height == null || height.length < 3) return 0;
        
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;
        
        while (left < right) {
            // Update maximum heights from both ends
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            
            // Move the pointer with smaller height
            // This ensures we always know the minimum of leftMax and rightMax
            if (height[left] < height[right]) {
                water += leftMax - height[left];
                left++;
            } else {
                water += rightMax - height[right];
                right--;
            }
        }
        
        return water;
    }
    
    /**
     * Alternative optimized solution using prefix/suffix arrays
     * This approach is more intuitive but uses O(n) extra space
     * 
     * @param height array representing bar heights
     * @return total amount of water that can be trapped
     */
    public static int findMaxCapacityAlternative(int[] height) {
        if (height == null || height.length < 3) return 0;
        
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        // Calculate maximum height to the left of each position
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        
        // Calculate maximum height to the right of each position
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        
        // Calculate trapped water at each position
        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        
        return water;
    }

    public static void main(String[] args) {
        // Test cases for the Trapping Rain Water problem
        int[] h1 = new int[]{0,1,0,2,1,0,1,3,2,1,2,4};
        int[] h2 = new int[]{2,1,3,2,3};
        int[] h3 = new int[]{3,1,1,1,1};
        int[] h4 = new int[]{1,1,1,1,3};
        int[] h5 = new int[]{3,1,1,1,3};
        int[] h6 = new int[]{4,2,0,3,2,5}; // LeetCode example
        int[] h7 = new int[]{3,0,2,0,4}; // Another common example
        int[] h8 = new int[]{1,2,3,4,5}; // Ascending - no water trapped
        int[] h9 = new int[]{5,4,3,2,1}; // Descending - no water trapped
        
        int[][] testCases = {h1, h2, h3, h4, h5, h6, h7, h8, h9};
        String[] descriptions = {
            "Complex case with multiple peaks and valleys",
            "Simple case with two containers",
            "Left wall higher than right",
            "Right wall higher than left", 
            "Symmetric case",
            "LeetCode example case",
            "Another common test case",
            "Ascending heights (no water)",
            "Descending heights (no water)"
        };
        
        System.out.println("Testing Trapping Rain Water Solutions:");
        System.out.println("=====================================");
        
        for (int i = 0; i < testCases.length; i++) {
            int[] heights = testCases[i];
            int result1 = findMaxCapacity(heights);
            int result2 = findMaxCapacityAlternative(heights);
            
            System.out.println("\nTest Case " + (i + 1) + ": " + descriptions[i]);
            System.out.println("Heights: " + java.util.Arrays.toString(heights));
            System.out.println("Two Pointers: " + result1);
            System.out.println("Prefix/Suffix: " + result2);
            System.out.println("Results match: " + (result1 == result2));
        }
    }
}
