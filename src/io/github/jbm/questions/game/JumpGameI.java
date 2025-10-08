package io.github.jbm.questions.game;
/* 
    LeetCode #55: Jump Game I
    
    Given nums where nums[i] is the max jump length from index i, start at index 0. 
    
    Return true if you can reach the last index, else false.
 */

public class JumpGameI {
    
    public static boolean canJump(int[] nums) {
        if (nums == null) return false;    // defensive

        int n = nums.length;
        if (n == 0) return true;          // if you want [] -> true
        if (n == 1) return true;          // already at last index

        int maxJump = 0;
        for (int i = 0; i < n; i++) {
            if (i > maxJump) return false;               // We can't reach this item
            maxJump = Math.max(maxJump, i + nums[i]);    // How far we can jump!
            if (maxJump >= n - 1) return true;           // Early success
        }
        
        // we never hit an unreachable index, so we can reach the end
        return true;   
    }
    
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));   // ✅ can reach last
        System.out.println(canJump(new int[]{0}));               // single element
        System.out.println(canJump(new int[]{2, 0}));            // jump directly
        System.out.println(canJump(new int[]{4, 0, 0, 0, 0}));   // jump past end
        System.out.println(canJump(new int[]{1, 2, 3}));         // step by step reachable
        System.out.println(canJump(new int[]{2, 5, 0, 0}));      // large first jump
        System.out.println(!canJump(new int[]{3, 2, 1, 0, 4}));  // ❌ stuck at index 3
        System.out.println(!canJump(new int[]{0, 2, 3}));        // cannot move from start
        System.out.println(!canJump(new int[]{1, 0, 1, 0}));     // stuck at index 1
        System.out.println(!canJump(new int[]{1, 1, 0, 1}));     // dead end at index 2
    }
}