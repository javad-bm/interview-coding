package io.github.jbm.questions.tree;

import java.util.ArrayDeque;
import java.util.Queue;

import io.github.jbm.questions.tree.lib.MatrixUtil;

/*
    Problem: Given a 2D matrix `height` representing land elevations,
    water starts flowing from the top-left corner (0,0).
    Water can only flow to adjacent cells **down or right** 
    if the next cell's height is **less than or equal** to the current cell.
    Goal: Find and mark all cells that water can reach from (0,0).

    This solution uses BFS (Breadth-First Search) to traverse
    all reachable cells and then prints the matrix with marks on reachable positions.
*/

class Index {
    int i;
    int j;

    Index(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        return "i: " + i + ", j=" + j;
    }
}

public class WaterLand {

    public static void findWaterStream(int[][] height) {
        if (height == null || height.length == 0 || height[0].length == 0) return;
        
        int n = height.length;        // Number of rows
        int m = height[0].length;     // Number of columns

        Queue<Index> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        Index rootIndex = new Index(0, 0);
        queue.offer(rootIndex);
        visited[0][0] = true;

        while (! queue.isEmpty()) {
            Index idx = queue.poll();          
            
            int nextI = idx.i + 1;
            int nextJ = idx.j + 1;
            if ( nextI < n && height[idx.i][idx.j] >= height[nextI][idx.j] && ! visited[nextI][idx.j])  {
                queue.add(new Index(nextI, idx.j));
                visited[nextI][idx.j] = true;
            }                
            if ( nextJ < m && height[idx.i][idx.j] >= height[idx.i][nextJ] && ! visited[idx.i][nextJ])  {
                queue.add(new Index(idx.i, nextJ));
                visited[idx.i][nextJ] = true;
            }                               
        }       
        MatrixUtil.printMatrixWithMarks(height, visited);
    }

    private static void runTest(String name, int[][] height) {
        System.out.println("==== " + name + " ====");
        findWaterStream(height);
        System.out.println();
    }

    public static void main(String[] args) {

        runTest("Regular Case", new int[][]{
            {8,5,4,3,2},
            {2,3,2,8,2},
            {1,5,6,4,1},
            {2,1,5,7,8}
        });

        runTest("Strictly Increasing — only (0,0) reachable", new int[][]{
            {1, 2, 3},
            {2, 3, 4},
            {3, 4, 5}
        });

        runTest("Strictly Decreasing — all reachable", new int[][]{
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        });

        runTest("Plateau Barrier — partial reachability", new int[][]{
            {1, 2, 2},
            {1, 1, 3},
            {2, 2, 4}
        });

        runTest("Right-Side Blocked — forces downward path", new int[][]{
            {1, 1, 0},
            {2, 2, 0},
            {3, 3, 0}
        });

        runTest("Single Row — horizontal traversal", new int[][]{
            {4, 3, 2, 3, 4}
        });

        runTest("Single Column — vertical traversal", new int[][]{
            {3},
            {2},
            {1},
            {2},
            {5}
        });
    }
}
