package com.yogesh.Arrays.Matrix;

public class MatrixProblems {
    public static void printSnakePattern(int[][] matrix){
        //Time Complexity - O(R x C), R is row and C is column
        for (int i = 0; i < matrix.length; i++){
            if (i % 2 == 0)
                for (int j = 0; j < matrix[i].length; j++)
                    System.out.print(matrix[i][j] + " ");
             else
                for (int j = matrix[i].length - 1; j >= 0 ; j--)
                    System.out.print(matrix[i][j] + " ");
        }

    }
}
