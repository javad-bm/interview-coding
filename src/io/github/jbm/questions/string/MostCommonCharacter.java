package io.github.jbm.questions.string;

import java.util.*;

public class MostCommonCharacter {

    public static Character findMostCommonChar(String str) {
        var countChar = new HashMap<Character, Integer>();
        for(Character c: str.toCharArray()) {
            countChar.put(c, countChar.getOrDefault(c,0) + 1);
        }

        List<Map.Entry<Character, Integer>> coutList = new ArrayList<>(countChar.entrySet());
        coutList.sort((e1,e2) -> e2.getValue().compareTo(e1.getValue()));
        return coutList.getFirst().getKey();
    }

    public static Character findMostCommonCharV2(String str) {
        var countChar = new HashMap<Character, Integer>();
        for(Character c: str.toCharArray()) {
            countChar.put(c, countChar.getOrDefault(c,0) + 1);
        }

        Integer max = 0;
        Character mostFrequent = null;
        for(Map.Entry<Character, Integer> e : countChar.entrySet()) {
            if (e.getValue() > max) {
               max = e.getValue();
               mostFrequent = e.getKey();
            }
        }

        return mostFrequent;
    }

    public static void main(String[] args) {
        System.out.println(findMostCommonChar("BcdefAbcdAAdref"));
        System.out.println(findMostCommonCharV2("BcdefAbcdAAdref"));
    }
}
