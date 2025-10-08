package io.github.jbm.questions.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostCommonEndpoint {

    public static void findMostCommon(String[] inputData, int k) {
        Map<String, Integer> endpointCounter = new HashMap<>();
        for (String s: inputData) {
            endpointCounter.put(s, endpointCounter.getOrDefault(s, 0) + 1);
        }

        Map<String, Integer> topK = endpointCounter
                .entrySet()
                .stream()
                .sorted(
                        Map.Entry.<String, Integer>comparingByValue().reversed()
                )
                .limit(k)
                .collect(
                        Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (e1, _) -> e1,  // merge function (not needed here)
                            LinkedHashMap::new             // preserve order
                        )
                );

        System.out.println(topK);
    }

    public static List<String> findMostCommon2(String[] inputData, int k) {

        return Arrays.stream(inputData).collect(
                        Collectors.groupingBy(Function.identity(), Collectors.counting())
                )
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(k)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> findMostCommonNoStream(String[] inputData, int k) {

        // 1) First count all strings
        var endpointCounterMap = new HashMap<String, Integer>();
        for (String s : inputData) {
//            endpointCounterMap.put(s, endpointCounterMap.getOrDefault(s, 0) + 1);
            endpointCounterMap.merge(s,1, Integer::sum);
        }

        // 2) Put the in the list to be able to sort them
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(endpointCounterMap.entrySet());

        // 3) Sort based on values
        entryList.sort(
                (e1,e2) -> {
                    if (e1.getValue() != e2.getValue()) {
                        return e2.getValue().compareTo(e1.getValue());
                    } else {
                        return e1.getKey().compareTo(e2.getKey());
                    }
                }
        );

        entryList.sort(
                Comparator.<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue)
                        .reversed()
                        .thenComparing(Map.Entry::getKey)
        );

        entryList.sort(
                Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey(Comparator.reverseOrder()))
        );

        var result = new ArrayList<String>();
        for(int i=0; i<Math.min(k, entryList.size()); i++) {
            result.add(entryList.get(i).getKey());
        }
        return result;

    }


        public static void main(String[] args) {
        System.out.println("Testing ...");
        String[] inputData = {"/get","/get","/put","/delete","/put","/get", "/test1", "/test1", "/test1", "/test1", "/test1", "/get","/get","/get", "/test2","/test2","/test2","/test2" };
        // List<String> inputDataList = List.of("/get","/get","/put","/delete","/put","/get", "/test1", "/test1", "/test1", "/test1", "/test1", "/get","/get","/get", "/test2","/test2","/test2","/test2");
      
        // findMostCommon(inputData, 2);
        // findMostCommon2(inputData, 2);
        System.out.println(findMostCommonNoStream(inputData, 3));
    }
}
