package com.yogesh.Arrays.Matrix;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class MatrixProblems {
    public static void printSnakePattern(int[][] matrix) {
        //Time Complexity - O(R x C), R is row and C is column
        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0)
                for (int j = 0; j < matrix[i].length; j++)
                    System.out.print(matrix[i][j] + " ");
            else
                for (int j = matrix[i].length - 1; j >= 0; j--)
                    System.out.print(matrix[i][j] + " ");
        }
    }

    public static void printBoundaryElements(int[][] matrix) {
        //Time Complexity - O(R + C)
        boolean singleRow = matrix.length == 1;
        boolean singleRowColumn = matrix[0].length == 1;
        if (singleRow) {
            for (int i = 0; i < matrix[0].length; i++)
                System.out.print(matrix[0][i] + " ");
        } else if (singleRowColumn) {
            for (int i = 0; i < matrix.length; i++)
                System.out.print(matrix[i][0] + " ");
        } else {
            for (int i = 0; i < matrix[0].length; i++)
                System.out.print(matrix[0][i] + " ");

            for (int i = 1; i < matrix.length - 1; i++)
                System.out.print(matrix[i][matrix[i].length - 1] + " ");

            for (int i = matrix[0].length - 1; i >= 0; i--)
                System.out.print(matrix[matrix.length - 1][i] + " ");

            for (int i = matrix.length - 2; i > 0; i--)
                System.out.print(matrix[i][0] + " ");
        }
    }

    public static int[][] transposeOfMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++)
            for (int j = i + 1; j < matrix.length; j++)
                swap(matrix, i, j);

        return matrix;
    }

    private static void swap(int[][] arr, int i, int j) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }

    public static int[][] rotateMatrixAntiClockWiseBy90Deg(int[][] matrix) {
        //Naive solution - O(n ^ 2) time and O(n ^ 2) Space
/*        int n = matrix.length;
        int[][] temp = new int[n][n];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                temp[n - j - 1][i] = matrix[i][j];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = temp[i][j];

        return matrix;
*/
        //O(n ^ 2) time, O(1) Space
        //first transpose the matrix and then swap individual columns, i.e, last column with first column and second last column with second column and so on.
        transposeOfMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            int low = 0;
            int high = matrix.length - 1;
            while (low < high) {
                //swapping rows
                int temp = matrix[low][i];
                matrix[low][i] = matrix[high][i];
                matrix[high][i] = temp;

                low++;
                high--;
            }
        }
        return matrix;
    }

    public static int[][] rotateMatrixClockWise(int[][] matrix){
/*        int[][] temp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                temp[j][i] = matrix[i][j];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = temp[i][j];

        return matrix;
 */
        transposeOfMatrix(matrix);
        for (int i = 0; i < matrix.length; i++){
            int low = 0; int high = matrix.length - 1;
            while (low < high){
                int temp = matrix[i][low];
                matrix[i][low] = matrix[i][high];
                matrix[i][high] = temp;
                low++;
                high--;
            }
        }
        return matrix;
    }

    public static void spiralTraversalOfMatrix(int[][] matrix) {
        //Time Complexity - O(R x C)
        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            //Print top row
            for (int i = left; i <= right; i++)
                System.out.print(matrix[top][i] + " ");
            top++;

            //Print right Column
            for (int i = top; i <= bottom; i++)
                System.out.print(matrix[i][right] + " ");
            right--;

            if (top <= bottom) {
                //Print bottom row (reverse order)
                for (int i = right; i >= left; i--)
                    System.out.print(matrix[bottom][i] + " ");
                bottom--;
            }
            if (left <= right) {
                //Print left Column (reverse order)
                for (int i = bottom; i >= top; i--)
                    System.out.print(matrix[i][left] + " ");
                left++;
            }
        }
    }

    public static void searchInSortedMatrix(int[][] matrix, int x) {
        //O(R x C) solution
/*        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                if (matrix[i][j] == x) {
                    System.out.println("Found at " + i + "," + j);
                    return;
                }
        System.out.println("Not Found");
 */
        //O(R + C) Solution
        int i = 0;
        int j = matrix[0].length - 1;
        int row = matrix.length;

        while (row > i && j >= 0) {
            if (matrix[i][j] == x) {
                System.out.println("Found at " + i + "," + j);
                return;
            } else if (matrix[i][j] < x)
                i++;
            else if (matrix[i][j] > x)
                j--;
        }
        System.out.println("Not found");
    }

    public static int medianOfRowSortedMatrix(int[][] matrix) {
        //O(log c * r * log (max - min))
        int row = matrix.length;
        int column = matrix[0].length;
        int min = matrix[0][0];
        int max = matrix[0][column - 1];

        for (int i = 1; i < row; i++) {
            if (matrix[i][0] < min)
                min = matrix[i][0];
            if (matrix[i][column - 1] > max)
                min = matrix[i][column - 1];
        }
        int medianPosition = (row * column + 1) / 2;
        while (min < max) {
            int mid = (min + max) / 2;
            int midPosition = 0;

            for (int i = 0; i < row; i++) {
                int pos = Arrays.binarySearch(matrix[i], mid) + 1;
                midPosition += Math.abs(pos);
            }

            if (midPosition < medianPosition)
                min = mid + 1;
            else
                max = mid;
        }
        return min;
    }

    public static void assignNumbersInMineSweeper(int[][] bombs, int row, int column) {
        int[][] matrix = new int[row][column];

        for (int[] bomb : bombs) {
            int rowIndex = bomb[0];
            int colIndex = bomb[1];
            matrix[rowIndex][colIndex] = -1;

            for (int i = rowIndex - 1; i < rowIndex + 2; i++)
                for (int j = colIndex - 1; j < colIndex + 2; j++)
                    if (i >= 0 && i < row && j >= 0 && j < column && matrix[i][j] != -1)
                        matrix[i][j] += 1;
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    public static int[][] findWhereToExpandMineSweeper(int[][] matrix, int numRows, int numCols, int givenI, int givenJ) {
        Queue<int[]> queue = new ArrayDeque<>();

        if (matrix[givenI][givenJ] == 0) {
            matrix[givenI][givenJ] = -2;
            int[] coordinates = {givenI, givenJ};
            queue.add(coordinates);
        } else
            return matrix;

        while (!queue.isEmpty()) {
            int[] currentCoordinates = queue.remove();
            int currentI = currentCoordinates[0];
            int currentJ = currentCoordinates[1];

            for (int i = currentI - 1; i < currentI + 2; i++)
                for (int j = currentJ - 1; j < currentJ + 2; j++)
                    if (i >= 0 && i < numRows && j >= 0 && j < numCols && matrix[i][j] == 0) {
                        matrix[i][j] = -2;
                        int[] coordinates = {i, j};
                        queue.add(coordinates);
                    }
        }
        return matrix;
    }
}
