package io.github.jbm.questions.basics;

import java.util.Arrays;

public class Pyramid {
    public static void drawPyramid(int n, char c) {
        for (int i=0; i<n; i++) {
            char[] chars = new char[2*n-1];
            Arrays.fill(chars, ' ');
            for (int j=n-i-1; j<=n-1+i; j++) {
                chars[j] = c;
            }
            System.out.println(String.valueOf(chars));
        }
    }

    public static void drawPyramidRecursive(int n, int m, char c) {
        drawRow(n, n, c);
    }

    public static void drawRow(int current, int total, char c) {
        if (current == 0) {
            // Base case, we are done!
            return;
        }

        // First draw the smaller line above!
        drawRow(current - 1, total, c);

        // Then, draw the current line!
        int width = 2 * total - 1;
        int middle = total - 1;
        char[] line = new char[width];
        Arrays.fill(line, ' ');

        for (int j = middle - (total - current); j <= middle + (total - current); j++) {
            line[j] = c;
        }
        System.out.println(new String(line));
    }

    public static void main(String[] args) {
        drawPyramid(5, '#');
        drawPyramidRecursive(5,0,'#');
    }
}
