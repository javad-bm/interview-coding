package io.github.jbm.questions.string;

import java.text.StringCharacterIterator;

public class StringTest {
    public static void main(String[] args){
        String s1 = "abc";
        for (char c : s1.toCharArray()) {
            System.out.println(c);
        }

        for(int i=0; i< s1.length(); i++){
            System.out.println(s1.charAt(i));
        }

        System.out.println(s1.chars());
        System.out.println(s1.chars().mapToObj(c -> (char)c));
        s1.chars().forEach(c -> System.out.println((char) c));

        StringCharacterIterator sci = new StringCharacterIterator(s1);
        while(sci.current() != StringCharacterIterator.DONE){
            System.out.println(sci.current());
            sci.next();
        }
    }
}
