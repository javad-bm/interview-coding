package io.github.jbm.questions.string;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }

        int startSubString = 0, endSubString = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int len_odd = expandFromCenter(s, i, i);
            int len_even = expandFromCenter(s, i, i + 1);
            int maxLen = Math.max(len_odd, len_even);
            if (maxLen > endSubString - startSubString) {
                startSubString = i - (maxLen - 1) / 2;
                endSubString = i + maxLen / 2;
            }
        }

        return s.substring(startSubString, endSubString+1);
    }

    public static int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        /*
        Example 1:
        Input: s = "babad"
        Output: "bab"
        Explanation: "aba" is also a valid answer.

        Example 2:
        Input: s = "cbbd"
        Output: "bb"
        */

        String s = "babad";
        System.out.println(longestPalindrome(s));

        String s2 = "cbbd";
        System.out.println(longestPalindrome(s2));

        String s3 = "ABCDEF ABCBA XYZDEF";
        System.out.println(longestPalindrome(s3));
    }
}
