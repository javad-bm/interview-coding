package io.github.jbm.questions.heap;

import java.util.*;

class MedianFinder {
    
    PriorityQueue<Integer> lowerMaxHeap;
    PriorityQueue<Integer> upperMinHeap;
    
    public MedianFinder() {
        this.lowerMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.upperMinHeap = new PriorityQueue<>();        
    }
    
    public void addNum(int num) {
        if (lowerMaxHeap.isEmpty() || num < lowerMaxHeap.peek()) {
            lowerMaxHeap.offer(num);
        } else {
            upperMinHeap.offer(num);
        }

        if (lowerMaxHeap.size() > upperMinHeap.size() + 1) {
            upperMinHeap.offer(lowerMaxHeap.poll());
        }        
        if (lowerMaxHeap.size() < upperMinHeap.size()) {
            lowerMaxHeap.offer(upperMinHeap.poll());
        }        

    }
    
    public double findMedian() {
        if (lowerMaxHeap.size() == upperMinHeap.size()) {
            return (float)(lowerMaxHeap.peek() + upperMinHeap.peek()) / 2.0f;
        }
        return lowerMaxHeap.peek();
    }

    public void printHeaps() {
        System.out.println(lowerMaxHeap.toString());
        System.out.println(upperMinHeap.toString());
    }
}

public class Median {
    public static void main(String[] args) {
        
        MedianFinder mf = new MedianFinder();
        mf.printHeaps();
        mf.addNum(5);
        mf.printHeaps();
        mf.addNum(1);
        mf.printHeaps();
        mf.addNum(15);
        mf.printHeaps();
        mf.addNum(3);
        mf.printHeaps();
        mf.addNum(2);
        mf.printHeaps();
        mf.addNum(7);
        mf.printHeaps();
    }
}
