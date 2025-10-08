package io.github.jbm.questions.basics;

import java.util.*;

public class MoveZeros {
    public static int[] moveZeroesHighSpaceComplexity(int[] nums) {
        List<Integer> nonZeroElements = new ArrayList<>();
        int zeroCount = 0;
        for (int element : nums) {
            if (element == 0) {
                zeroCount++;
            } else {
                nonZeroElements.add(element);
            }
        }
        int[] result = new int[nonZeroElements.size() + zeroCount];
        for (int i = 0; i < nonZeroElements.size(); i++) {
            result[i] = nonZeroElements.get(i);
        }
        return result;
    }

    public static void moveZeroes(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        i++;
                    }
                }
            }
            i++;
        }
    }

    public static void main(String[] args) {
        /*
        Example 1:
        Input: nums = [0,1,0,3,12]
        Output: [1,3,12,0,0]

        Example 2:
        Input: nums = [0]
        Output: [0]
        */
        int[] test1 = {0,0,1,0,3,0,12,0};
        int[] test2 = {0,0,1};
        int[] test3 = {2,1,3,4,5};
//        System.out.println(Arrays.toString(moveZeroesHighSpaceComplexity(test1)));
//        System.out.println(Arrays.toString(moveZeroesHighSpaceComplexity(test2)));
//        System.out.println(Arrays.toString(moveZeroesHighSpaceComplexity(test3)));

        moveZeroes(test1);
        System.out.println(Arrays.toString(test1));

        moveZeroes(test2);
        System.out.println(Arrays.toString(test2));

        moveZeroes(test3);
        System.out.println(Arrays.toString(test3));

    }
}
