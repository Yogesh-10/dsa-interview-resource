package com.yogesh.Arrays.Matrix;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] matrix2 = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] matrix3 = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] res1 = MatrixProblems.transposeOfMatrix(matrix);
        int[][] res2 = MatrixProblems.rotateMatrixAntiClockWiseBy90Deg(matrix2);
        int[][] res3 = MatrixProblems.rotateMatrixClockWise(matrix3);
        System.out.println(Arrays.deepToString(res1));
        System.out.println(Arrays.deepToString(res2));
        System.out.println(Arrays.deepToString(res3));
    }
}
