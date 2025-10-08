package io.github.jbm.questions.game;
/*
    LeetCode 45: Jump Game II

    You are given a 0-indexed array of integers nums of length n.
    Each element nums[i] represents your maximum jump length at that position.
    Your goal is to reach the last index in the minimum number of jumps.
    You can assume that you can always reach the last index.
    
    Return the minimum number of jumps to reach the last index.
 */

public class JumpGameII {

    public static int findMinJump(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;

        int jumps = 0;
        int currentEnd = 0;  // end of the current "layer"
        int farthest = 0;    // farthest index reachable so far

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {        // finish current layer; start next
                jumps++;
                currentEnd = farthest;
            }
            if (currentEnd >= nums.length - 1) {
                return jumps;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        
        System.out.println(findMinJump(new int[]{2,3,1,1,4}) == 2);   // ✅ 0→1→4
        System.out.println(findMinJump(new int[]{2,3,0,1,4}) == 2);   // ✅ 0→1→4

        // ✅ Small arrays
        System.out.println(findMinJump(new int[]{0}) == 0);           // already at end
        System.out.println(findMinJump(new int[]{1}) == 0);           // single element
        System.out.println(findMinJump(new int[]{1,2}) == 1);         // one jump to end
        System.out.println(findMinJump(new int[]{2,1}) == 1);         // one jump to end

        // ✅ Longer patterns
        System.out.println(findMinJump(new int[]{1,1,1,1}) == 3);        // must jump each step
        System.out.println(findMinJump(new int[]{4,1,1,1,1,1}) == 2);    // jump directly past end
        System.out.println(findMinJump(new int[]{2,1,2,3,1,1,1}) == 3);
        System.out.println(findMinJump(new int[]{5,4,3,2,1}) == 1);  // one jump covers all

        // ✅ Edge behavior
        System.out.println(findMinJump(new int[]{1,2,0,1}) == 2);
        System.out.println(findMinJump(new int[]{3,2,1,0,4,2,1}) == 2);   // 0→1→4
        System.out.println(findMinJump(new int[]{1,3,2,1,0,4,2,1,0,4}) == 3);

        System.out.println(findMinJump(new int[]{2,14,1,1,1,1,1,1,1,1,1,1,1,1,1,1}) == 2);
    }
}
