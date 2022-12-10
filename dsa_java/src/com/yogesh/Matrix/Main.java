package com.yogesh.Matrix;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] res = MatrixProblems.transposeOfMatrix(matrix);
        System.out.println(Arrays.deepToString(res));
    }
}
