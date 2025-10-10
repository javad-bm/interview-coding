package io.github.jbm.questions.tree.lib;

public class MatrixUtil {

    private static final String GREEN = "\u001B[32m";
    private static final String RESET = "\u001B[0m";

    public static void printMatrixWithMarks(int[][] matrix, boolean[][] mark) {
        if (matrix == null || mark == null) {
            throw new IllegalArgumentException("Matrices must not be null");
        }
        if (matrix.length != mark.length || matrix[0].length != mark[0].length) {
            throw new IllegalArgumentException("Matrix and mark dimensions must match");
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (mark[i][j]) {
                    // Mark true cells with * and optional color
                    System.out.printf(GREEN + "%2d* " + RESET, matrix[i][j]);
                } else {
                    System.out.printf("%2d  ", matrix[i][j]);
                }
            }
            System.out.println();
        }
    }
}