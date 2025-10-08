package io.github.jbm.questions.basics;

import java.util.Arrays;

public class Step {
    public static void drawStep(int n, char c) {
        for(int i = 1; i <= n; i++) {
            char[] chars = new char[n+2];
            Arrays.fill(chars, ' ');
            chars[0] = '\'';
            chars[n+1] = '\'';
            for(int j=1; j<=i; j++) {
                chars[j] = c;
            }
            System.out.println(String.valueOf(chars));
        }
    }

    public static void drawStepV2(int n, char c) {
        for(int i=0; i < n; i++) {
            char[] chars = new char[n];
            for(int j=0; j<n; j++) {
                if (i<j) {
                    chars[j] = ' ';
                } else {
                    chars[j] = c;
                }
            }
            System.out.println(String.valueOf(chars));
        }


    }
    public static void main(String[] args) {
        drawStep(10, '*');
        drawStepV2(10, '*');
    }
}
