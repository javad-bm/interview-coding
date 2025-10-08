package io.github.jbm.questions.two.pointers;


public class MaxContainer {

    public static int maxAreaOn2(int[] height) {
        int maxArea = 0;
        for(int i=0; i<height.length; i++) {
            for(int j=i+1; j<height.length; j++) {
                maxArea = Math.max(
                        maxArea, Math.min(height[i], height[j]) * (j-i)
                );
            }
        }
        return maxArea;
    }

    /*
    When we move pointers:
        1. The width always decreases.
        2. To possibly get a larger area, the height must increase enough to compensate for the reduced width.
        3.Since the area is limited by the shorter line, moving the taller one won’t help — height stays the same or smaller.
    Thus:
        => Move the pointer pointing to the shorter line.
     */

    public static int maxAreaOn(int[] height) {
        int maxArea = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            maxArea = Math.max(maxArea, (r-l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }


    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxAreaOn(height));

    }
}
