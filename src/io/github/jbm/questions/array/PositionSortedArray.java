package io.github.jbm.questions.array;

import java.util.Arrays;

/*
Given an array of integers nums sorted in non-decreasing order,
find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]
 */

public class PositionSortedArray {

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int[] searchRange(int[] nums, int target) {
        int foundIndex = binarySearch(nums, target);
        if (foundIndex == -1) {
            return new int[]{-1,-1};
        }
        int start = foundIndex;
        int end = foundIndex;

        while (start > 0 && nums[start-1] == target) {
            start--;
        }
        while (end < nums.length-1 && nums[end+1] == target) {
            end++;
        }

        return new int[]{start, end};

    }

    public static void main(String[] args) {
        int[] nums = {5,6,7,8,10,12,13};
        System.out.println(String.valueOf(binarySearch(nums, 5)).equals("0"));
        System.out.println(String.valueOf(binarySearch(nums, 7)).equals("2"));
        System.out.println(String.valueOf(binarySearch(nums, 10)).equals("4"));
        System.out.println(String.valueOf(binarySearch(nums, 13)).equals("6"));
        System.out.println(String.valueOf(binarySearch(nums, 9)).equals("-1"));
        System.out.println(String.valueOf(binarySearch(nums, 20)).equals("-1"));

        int[] nums1 = {5,7,7,8,8,8,10};
        System.out.println(Arrays.toString(searchRange(nums1, 8)));

        int[] nums2 = {5,5,5,7,7,8,8,10,10,10};
        System.out.println(Arrays.toString(searchRange(nums2, 5)));
        System.out.println(Arrays.toString(searchRange(nums2, 10)));
        System.out.println(Arrays.toString(searchRange(nums2, 6)));
    }
}
