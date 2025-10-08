package io.github.jbm.questions.array;

import java.util.Arrays;

public class MergeSortedArrays {
    public static int[] merge(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return nums2;
        }
        if (nums2 == null || nums2.length == 0) {
            return nums1;
        }

        int i = 0, j = 0, k = 0;
        int[] result = new int[nums1.length + nums2.length];
        while (i < nums1.length && j < nums2.length) {
            result[k++] = (nums1[i] > nums2[j]) ? nums2[j++] : nums1[i++];
        }

        while (i < nums1.length) {
            result[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            result[k++] = nums2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] l1 = {5,40,300,600,800};
        int[] l2 = {10,50,51,52,53,80,100};

        System.out.println(Arrays.toString(merge(l1, l2)));

    }
}
