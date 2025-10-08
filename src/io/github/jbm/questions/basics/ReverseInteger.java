package io.github.jbm.questions.basics;

public class ReverseInteger {

    public static int reverse(int x) {
        boolean isNegative = x < 0;
        if (isNegative) x = -x;
        long result = 0;
        while (x > 0) {
            int r = x % 10;
            result = result * 10 + r;
            x = x / 10;
        }
        if (isNegative) result = -result;

        // Handle overflow for 32-bit int
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123) == 321);
        System.out.println(reverse(-123) == -321);
        System.out.println(reverse(120) == 21);
        System.out.println(reverse(0) == 0);
        System.out.println(reverse(1534236469) == 0);
    }
}
