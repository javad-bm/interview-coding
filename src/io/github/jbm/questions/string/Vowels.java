package io.github.jbm.questions.string;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vowels {
    private static final Set<Character> VOWELS = new HashSet<>();
    static {
        VOWELS.add('e');
        VOWELS.add('i');
        VOWELS.add('o');
        VOWELS.add('u');
        VOWELS.add('a');
    }

    public static final Pattern VOWELS_PATTERN = Pattern.compile("[aeiou]", Pattern.CASE_INSENSITIVE);

    public static int countVowels(String str) {

        int counter = 0;
        for(char c : str.toLowerCase().toCharArray()) {
            if (VOWELS.contains(c))
                counter++;
        }
        return counter;
    }

    public static int countVowelsRegex(String str) {
        Matcher m = VOWELS_PATTERN.matcher(str);
        int count = 0;
        while (m.find()) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countVowels("I am OK!!!"));
        System.out.println(countVowelsRegex("I am OK!!!"));
    }
}
