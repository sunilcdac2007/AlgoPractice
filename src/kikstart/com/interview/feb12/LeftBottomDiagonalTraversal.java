package com.interview.feb12;

public class LeftBottomDiagonalTraversal {
    public static void main(String[] args) {
        int[][] mat= {{1,  2,   3 , 4},
                      {5,  6,   7,  8},
                      {9,  10,  11,  12},
                      {13, 14,  15, 16}};
        matrixTraversal(mat);
        /*

      13
	  9 14
	  5 10 15
	  1 6 11 16
	  2 7 12
	  3 8
	  4
         */
    }

    public static void matrixTraversal(int[][] matrix){

        for(int row= matrix.length-1; row >=0; row--){
            int start = row;
            int end = 0;
            while(start< matrix.length && end < matrix.length){
                System.out.print(matrix[start++][end++]+" ");
            }
            System.out.println();
        }
        for(int col=1; col < matrix.length; col++){
            int start=0;
            int end = col;
            while(end < matrix.length){
                System.out.print(matrix[start++][end++]+" ");
            }
            System.out.println();
        }


    }

}
