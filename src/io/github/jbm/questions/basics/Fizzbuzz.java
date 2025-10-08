package io.github.jbm.questions.basics;

import java.util.ArrayList;
import java.util.List;

public class Fizzbuzz {
    public static List<String> fizzuzz(int n) {
        int count3 = 0;
        int count5=0;
        List<String> result = new ArrayList<String>();
        for(int i=1; i<=n; i++) {
            count3++;
            count5++;
            if (count5 == 5 && count3 == 3) {
                result.add("fizzbuzz");
                count5 = 0;
                count3 = 0;
            } else if (count5 == 5) {
                result.add("buzz");
                count5 = 0;
            } else if (count3 == 3) {
                result.add("fizz");
                count3 = 0;
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

    public static List<String> fizzuzzV2(int n) {
        List<String> result = new ArrayList<String>();
        for(int i=1; i<=n; i++) {
            if (i % 15 == 0) {
                result.add("fizzbuzz");
            } else if (i % 5 == 0) {
                result.add("buzz");
            } else if (i % 3 == 0) {
                result.add("fizz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fizzuzz(30));
        System.out.println(fizzuzzV2(30));
    }
}
