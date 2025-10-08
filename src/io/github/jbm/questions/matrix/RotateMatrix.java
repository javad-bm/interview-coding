package io.github.jbm.questions.matrix;

import java.util.Arrays;

public class RotateMatrix {

    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotate(int[][] matrix) {

        int numberOfRows = matrix.length;
        int numberOfColumns = matrix[0].length;

        // Transpose the Matrix
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = i; j < numberOfColumns; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Reverse each row
        for (int i = 0; i < matrix[0].length; i++) {
            reverseArray(matrix[i]);
        }


    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        // Number of rows
        System.out.println(matrix.length);

        // Number of columns
        System.out.println(matrix[0].length);

        System.out.println(Arrays.deepToString(matrix));
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
