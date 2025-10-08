package io.github.jbm.questions.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static boolean isAnagram(String str1, String str2) {
        String str1Cleaned = str1.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String str2Cleaned = str2.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (str1Cleaned.length() != str2Cleaned.length())
            return false;

        Map<Character, Integer> countCharactersMap = new HashMap<>();
        for (Character c : str1Cleaned.toCharArray()) {
            countCharactersMap.put(c, countCharactersMap.getOrDefault(c,0) + 1);
        }
        for (Character c : str2Cleaned.toCharArray()) {
            if (!countCharactersMap.containsKey(c) || countCharactersMap.get(c) == 0)
                return false;
            countCharactersMap.put(c, countCharactersMap.get(c) - 1);
        }

        for (Map.Entry<Character, Integer> e : countCharactersMap.entrySet()) {
            if (e.getValue() > 0)
                return false;
        }

        return true;
    }

    public static boolean isAnagramV2(String s1, String s2) {
        String s1Cleaned = s1.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String s2Cleaned = s2.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        char[] s1CleanedCharArray = s1Cleaned.toCharArray();
        char[] s2CleanedCharArray = s2Cleaned.toCharArray();

        Arrays.sort(s1CleanedCharArray);
        Arrays.sort(s2CleanedCharArray);

        return Arrays.equals(s1CleanedCharArray, s2CleanedCharArray);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("TEST", "  TeS!t"));
        System.out.println(isAnagram("ABCDAA", "AAABCD"));
        System.out.println(isAnagram("ABCD", "ABCA"));

        System.out.println(isAnagramV2("TEST", "  TeS!t"));
        System.out.println(isAnagramV2("ABCDAA", "AAABCD"));
        System.out.println(isAnagramV2("ABCD", "ABCA"));

    }
}
