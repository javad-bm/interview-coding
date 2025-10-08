package io.github.jbm.questions.array;

import java.util.Arrays;

public class RotateArray {
    public static void rotateOne(int[] nums) {
        int temp = nums[nums.length - 1];
        for (int i = nums.length -1 ; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = temp;
    }

    public static void  rotateSlow(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            rotateOne(nums);
        }
    }

    public static void reverse(int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n; // Handle cases where k is larger than the array size

        reverse(nums, 0, n - 1);  // Step 1: Reverse the entire array
        reverse(nums, 0, k - 1);  // Step 2: Reverse the first k elements
        reverse(nums, k, n - 1);  // Step 3: Reverse the remaining elements
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] test1 = {1,2,3,4,5};
        rotateOne(test1);
        System.out.println(Arrays.toString(test1));

        int[] test2 = {0,1,2,3,4,5,6,7,8};
        rotateSlow(test2, 3);
        System.out.println(Arrays.toString(test2));

        int[] test3 = {0,1,2,3,4,5,6,7,8};
        reverse(test3);
        System.out.println(Arrays.toString(test3));

        int[] test4 = {0,1,2,3,4,5,6,7};
        rotate(test4,3);
        System.out.println(Arrays.toString(test4));

        int[] test5 = {-1};
        rotate(test5,5);
        System.out.println(Arrays.toString(test5));

        int[] test6 = {1,2};
        rotate(test6,3);
        System.out.println(Arrays.toString(test6));

    }
}
