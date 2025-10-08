package io.github.jbm.questions.string;

import java.util.*;

public class CountWords {
    public static final Set<String> STOP_WORDS = new HashSet<>(
            Arrays.asList("a", "and", "off")
    );

    public static boolean isNumberCoPilot(String s) {
        return s != null && !s.isEmpty() && s.chars().allMatch(Character::isDigit);
    }

    public static boolean isNumber(String s) {
        char[] chars = s.toCharArray();
        for(char c : chars) {
            if (! Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static List<String> countWords(String text) {
        List<String> result = new ArrayList<>();
        String[] words = text.split("\\s+");
        for (String w : words) {
            String cleanedWord = w.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            if (!cleanedWord.isEmpty() && !STOP_WORDS.contains(cleanedWord) & !isNumber(cleanedWord)) {
                result.add(cleanedWord);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(countWords("I'm number 15 from 20-students"));
    }
}
