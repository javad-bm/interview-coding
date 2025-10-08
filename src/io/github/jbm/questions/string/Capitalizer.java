package io.github.jbm.questions.string;

public class Capitalizer {
    public static String capitalize(String str) {
        if (str == null || str.isBlank())
            return str;

        char[] charArray = str.toCharArray();

        charArray[0] = Character.toUpperCase(charArray[0]);
        for(int i=1; i < charArray.length; i++) {
            if (charArray[i-1] == ' ') {
                charArray[i] = Character.toUpperCase(charArray[i]);
            }
        }

        return new String(charArray);
    }

    public static String capitalizeV2(String str) {
        if (str == null || str.isBlank())
            return str;

        String[] words = str.split("[ +]");
        for(int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            chars[0] = Character.toUpperCase(chars[0]);
            words[i] = String.valueOf(chars);

        }
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        System.out.println(capitalize("i am testing this!! "));
        System.out.println(capitalizeV2("i am testing this!! "));
        System.out.println(capitalizeV2("what do you want from me:  "));
    }
}
