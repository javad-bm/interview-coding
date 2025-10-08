package io.github.jbm.questions.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chunk {
    public static List<List<Integer>> chunkArray(int[] inputArray, int size) {
        var result = new ArrayList<List<Integer>>();
        List<Integer> chunk = new ArrayList<>();
        for (int num : inputArray) {
            chunk.add(num);
            if (chunk.size() == size) {
                result.add(chunk);
                chunk = new ArrayList<>();
            }
        }
        if (!chunk.isEmpty())
            result.add(chunk);

        return result;
    }

    public static List<int[]> chunkArrayV2(int[] inputArray, int size) {
        int index = 0;
        var result = new ArrayList<int[]>();
        while(index < inputArray.length) {
            int[] slice = Arrays.copyOfRange(inputArray, index, Math.min(index + size, inputArray.length));
            result.add(slice);
            index += size;
        }
        return result;

    }
    public static void main(String[] args) {
        int[] inputArray = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        System.out.println(chunkArray(inputArray, 3));

        for(int[] c : chunkArrayV2(inputArray, 3)) {
            System.out.println(Arrays.toString(c));
        }
    }
}
