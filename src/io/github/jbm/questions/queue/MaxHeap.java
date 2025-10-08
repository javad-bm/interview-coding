package io.github.jbm.questions.queue;

public class MaxHeap {

    public static void insertMaxHeap(int[] heap, int size, int value) {

        // Add the new element to the end of the heap
        heap[size] = value;

        // Get the index of the last element
        int index = size;

        // Compare the new element with its parent and swap if necessary
        while (index > 0 && heap[(index - 1) / 2] < heap[index]) {

            swap(heap, index, (index - 1) / 2);

            // Move up the tree to the parent of the current element
            index = (index - 1) / 2;
        }
    }

    // Function to swap two elements in an array
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] heap = new int[6];
        int[] values = {10, 7, 11, 5, 4, 13};
        int size = 0;
        for (int value : values) {
            insertMaxHeap(heap, size, value);
            size++;
            System.out.print("Inserted " + value + " into the min-heap: ");
            for (int j = 0; j < size; j++) {
                System.out.print(heap[j] + " ");
            }
            System.out.println();
        }
    }
}

