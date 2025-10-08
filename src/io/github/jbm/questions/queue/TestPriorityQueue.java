package io.github.jbm.questions.queue;

import java.util.*;

public class TestPriorityQueue {
    public static void testPriorityQueue() {
        
        // Default PQ, order from min to max
        // var p = new PriorityQueue<Integer>();      
        
        // Like the default PQ, from min to max
        // var p = new PriorityQueue<Integer>((e1, e2) -> e1.compareTo(e2));
        // var p = new PriorityQueue<Integer>(Comparator.comparingInt(Integer::intValue));
        
        // PQ with revese order from Max to Min
        // var p = new PriorityQueue<Integer>((e1, e2) -> e2.compareTo(e1));
        // var p = new PriorityQueue<Integer>(Collections.reverseOrder());
        var p = new PriorityQueue<Integer>(Comparator.comparingInt(Integer::intValue).reversed());
        
        p.add(10); p.add(20); p.add(11); p.add(3); p.add(5);
        p.offer(54);

        System.out.println(p);

        System.out.println(p.peek());
        System.out.println(p);
        System.out.println(p.poll());
        System.out.println(p);
        System.out.println(p.poll());
        System.out.println(p);
        System.out.println(p.poll());
        System.out.println(p);
        System.out.println(p.poll());
        System.out.println(p);

        // Storying a map in PQ and get them based on the biggest value!
        // var p2 = new PriorityQueue<Map.Entry<String, Integer>>((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        var p2 = new PriorityQueue<Map.Entry<String, Integer>>(Map.Entry.comparingByValue(Collections.reverseOrder()));

        Map<String, Integer> test_map = Map.of("Test1", 10, "Test2", 20, "Test3", 30);
        p2.addAll(test_map.entrySet());

        System.out.println(p2.poll());
        System.out.println(p2.poll());
        System.out.println(p2.poll());
    }

    public static void main(String[] args) {
        testPriorityQueue();
    }
}
