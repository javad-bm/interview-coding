package io.github.jbm.questions.string;

public class ReverseString {

    public static String reverseString(String s) {
        char[] reversed = new char[s.length()];
        int j = 0;
        for(int i = s.length()-1; i>=0; i--) {
            reversed[j] = s.charAt(i);
            j++;
        }
        return new String(reversed);

    }

    public static String reverseStringV2 (String s) {
        char[] stringChars = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        char temp;
        while(start < end) {
            temp = stringChars[start];
            stringChars[start] = stringChars[end];
            stringChars[end] = temp;
            start++;
            end--;
        }
        return new String(stringChars);
    }

    public static String reverseStringV3(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .reduce("", (s, c) -> c + s, (s1, s2) -> s2 + s1);
    }

    public static void main(String[] args) {
        String test = "Javad Behrouzi";
        System.out.println(reverseString(test));
        System.out.println(reverseStringV2(test));
        System.out.println(reverseStringV3(test));

    }
}
