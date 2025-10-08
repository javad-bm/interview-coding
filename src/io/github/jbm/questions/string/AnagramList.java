package io.github.jbm.questions.string;

import java.util.*;

public class AnagramList {

    public static List<String> removeAnagram(List<String> text) {
        List<String> result = new ArrayList<>();
        Set<String> anagramSet = new HashSet<>();
        for(String word : text) {
            char[] wordChars = word.toCharArray();
            Arrays.sort(wordChars);
            String sortedWord = new String(wordChars);
            if (! anagramSet.contains(sortedWord)) {
                anagramSet.add(sortedWord);
                result.add(word);
            }
        }
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        List<String> text = List.of("code", "edoc", "doce", "text", "extt");
        System.out.println(removeAnagram(text));
    }
}
