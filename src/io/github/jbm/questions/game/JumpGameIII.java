package io.github.jbm.questions.game;
/*
    1306. Jump Game III

    Given an array of non-negative integers arr, you are initially positioned at start index of the array. 
    When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach any index with value 0.
    Notice that you can not jump outside of the array at any time.
 */

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII {

    public static boolean canReach(int[] nums, int start) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        
        queue.offer(start);
        visited[start] = true;

        while (! queue.isEmpty()) {
            int idx = queue.poll();
            if (nums[idx] == 0) {
                return true;
            }

            int idxRight = idx + nums[idx];
            if (idxRight < nums.length && !visited[idx]) {
                queue.offer(idxRight);
            }

            int idxLeft = idx - nums[idx];
            if (idxLeft >0 && !visited[idxLeft]) {
                queue.offer(idxLeft);
            }            
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5)); // 5->4->1->3
        System.out.println(canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 0)); // 0->4->1->3
        System.out.println(!canReach(new int[]{3, 0, 2, 1, 2}, 2));    // trapped by revisits
        System.out.println(canReach(new int[]{0}, 0));
    }
}
