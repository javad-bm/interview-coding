package io.github.jbm.questions.string;

public class StringToInteger {
    public static int stringToInteger(String s) {
        int startIndex = 0;
        boolean isDigit = false;
        boolean negative = false;
        while (startIndex < s.length() && !isDigit) {
            if (s.charAt(startIndex) == '-'
                    || s.charAt(startIndex) == '+'
                    || s.charAt(startIndex) == ' '
            ) {
                if (s.charAt(startIndex) == '-') {
                    negative = true;
                }
                startIndex++;
            } else {
                isDigit = true;
            }
        }

        String subString =  s.substring(startIndex);
        int total = 0;
        for (int i = 0; i < subString.length(); i++) {
            int digit = subString.charAt(i) - '0';
            if (digit > 9 || digit < 0) {
                break;
            }

            if (total > (Integer.MAX_VALUE - digit) / 10) {
                return (negative) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            total = total * 10 + digit;
        }
        return  (negative) ? total * (-1) : total;
    }

    public static void main(String[] args) {
        String test1 = "  -00000112312321";
        System.out.println(stringToInteger(test1));

        String test2 = "  +000112312321";
        System.out.println(stringToInteger(test2));

        String test3 = "112312321";
        System.out.println(stringToInteger(test3));

        String test4 = "   000112312321";
        System.out.println(stringToInteger(test4));

        String test5 = "1337c0d3";
        System.out.println(stringToInteger(test5));

        String test6 = "0-1";
        System.out.println(stringToInteger(test6));

        String test7 = "words and 987";
        System.out.println(stringToInteger(test7));

    }
}
