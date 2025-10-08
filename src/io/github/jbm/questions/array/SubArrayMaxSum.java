package io.github.jbm.questions.array;

import java.util.Arrays;

public class SubArrayMaxSum {
    public static int[] findSubArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int maxSum = arr[0];
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i ; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum > maxSum) {
                    maxSum = sum;
                    startIndex = i;
                    endIndex = j;
                }
            }
        }
        return new int[]{startIndex, endIndex, maxSum};
    }

    public static int findSubArrayV2(int[] arr) {
        int maxSum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i ; j < arr.length; j++) {
                sum += arr[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    public static int findSubArrayV3(int[] arr) {
        int maxSum = arr[0];
        int sum = 0;
        for (int element : arr) {
            sum += element;
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] subArray = findSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(Arrays.toString(subArray));

        int[] subArray2 = findSubArray(new int[]{5,4,-1,7,8});
        System.out.println(Arrays.toString(subArray2));

        int[] subArray3 = findSubArray(new int[]{1});
        System.out.println(Arrays.toString(subArray3));

        int[] subArray4 = findSubArray(new int[]{-2,1});
        System.out.println(Arrays.toString(subArray4));

        System.out.println(findSubArrayV2(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(findSubArrayV2(new int[]{5,4,-1,7,8}));
        System.out.println(findSubArrayV2(new int[]{-1}));
        System.out.println(findSubArrayV2(new int[]{-2,1}));

        System.out.println(findSubArrayV3(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(findSubArrayV3(new int[]{5,4,-1,7,8}));
        System.out.println(findSubArrayV3(new int[]{-1}));
        System.out.println(findSubArrayV3(new int[]{-2,1}));

    }
}
