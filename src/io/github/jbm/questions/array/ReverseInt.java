package io.github.jbm.questions.array;

public class ReverseInt {
    public static int reverseInt(Integer num) {
        String s = num.toString().trim();
        boolean isNegative = false;
        if (s.startsWith("-")) {
            isNegative = true;
            s = s.substring(1);
        }

        String reversed = new StringBuilder(s).reverse().toString();
        if (isNegative) {
            reversed = "-" + reversed;
        }

        return Integer.parseInt(reversed);

    }
    public static void main(String[] args) {
        System.out.println(reverseInt(1234));
        System.out.println(reverseInt(-12345));
        System.out.println(reverseInt(78910));
    }
}
