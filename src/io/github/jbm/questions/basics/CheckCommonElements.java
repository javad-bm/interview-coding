package io.github.jbm.questions.basics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CheckCommonElements {
    public static boolean checkCommonElements(List<Object> l1, List<Object> l2){
        HashSet<Object> l1_set = new HashSet<>(l1);
        for(Object o : l2) {
            if (l1_set.contains(o)) {
                return true;
            }
        }
//        This doesn't work, since you can't return from lambda,
//        We can throw exception and catch it, or just set a flag

//        l2.forEach(o -> {
//            if (l1_set.contains(o)) {
//                return true;
//            }
//        });

        return false;
    }

    public static void main(String[] args) {
        // This one is immutable
        List<Object> l1 = List.of("a","javad");
        List<Object> l2 = List.of("a1","e", "javad");
        System.out.println(l2.get(1));

        // This is mutable
        List<Object> l3 = new ArrayList<>();
        l3.add("a");
        l3.add("b");
        l3.add("b");
        l3.add("b");
        l3.add("b");
        l3.add("b");
        l3.add(5,"f");
        l3.add(4,"Test");
        System.out.println(l3);

        l3.addLast("last");
        l3.addFirst("first");
        System.out.printf("%s,%d\n", l3.get(1), l3.size());

        l3.removeFirst();
        System.out.println(l3);
        l3.removeLast();
        System.out.println(l3);

        System.out.println(String.valueOf(checkCommonElements(l1,l2)));

        Object[] my_test = {"a","b"};
        System.out.println(my_test[0]);

        Object[] my_test_2 = new Object[10];
        my_test_2[0] = "a";
        System.out.printf(String.valueOf(my_test_2.length));

    }
}
