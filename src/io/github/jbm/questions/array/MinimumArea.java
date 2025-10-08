package io.github.jbm.questions.array;
/*

You are given a 2D binary array grid. Find a rectangle with horizontal and vertical sides with the smallest area,
such that all the 1's in grid lie inside this rectangle.

Return the minimum possible area of the rectangle.

Example 1:
Input: grid = [[0,1,0],[1,0,1]]
Output: 6

Explanation:
The smallest rectangle has a height of 2 and a width of 3, so it has an area of 2 * 3 = 6.

Example 2:
Input: grid = [[1,0],[0,0]]
Output: 1

Explanation:
The smallest rectangle has both height and width 1, so its area is 1 * 1 = 1.
*/

public class MinimumArea {
    public static int minimumArea(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int minI = Integer.MAX_VALUE, minJ = Integer.MAX_VALUE;
        int maxI = Integer.MIN_VALUE, maxJ = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    if (minI > i) minI = i;
                    if (maxI < i) maxI = i;
                    if (minJ > j) minJ = j;
                    if (maxJ < j) maxJ = j;
                }
            }
        }

        if (minI == Integer.MAX_VALUE) {
            return 0;
        }
        return (maxI-minI+1) * (maxJ-minJ+1);
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,1,0},
                {1,0,1}
        };
        System.out.println(minimumArea(grid) == 6);

        grid = new int[][]{
                {0, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0}
        };
        System.out.println(minimumArea(grid) == 20);
    }
}
