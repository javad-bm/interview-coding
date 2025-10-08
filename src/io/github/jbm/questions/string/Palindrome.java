package io.github.jbm.questions.string;

public class Palindrome {
    public static boolean isPalindrome(String str) {
        if (str.isEmpty()) return true;
        if (str.length() == 1) return true;
        if ((str.length() % 2) != 0) return false;

        int start = 0;
        int end = str.length() - 1;
        char[] inputCharacters = str.toCharArray();
        while (start < end) {
            if (inputCharacters[start] != inputCharacters[end])
                return false;
            start++;
            end--;
        }
        return true;

    }

    public static boolean isPalindromeV2(String str) {
        // We can clean the string if we need to
        //String cleanedString = str.replaceAll("^a-zA-Z0-9", "").toLowerCase();

        String reversedString = new StringBuilder(str).reverse().toString();
        return reversedString.equals(str);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("ABCD"));
        System.out.println(isPalindrome("ABBA"));
        System.out.println(isPalindrome("A"));
        System.out.println(isPalindrome("ABCCBA"));
        System.out.println(isPalindrome(""));

        System.out.println(isPalindromeV2("ABCD"));
        System.out.println(isPalindromeV2("ABBA"));
        System.out.println(isPalindromeV2("A"));
        System.out.println(isPalindromeV2("ABCCBA"));
        System.out.println(isPalindromeV2(""));

    }
}
