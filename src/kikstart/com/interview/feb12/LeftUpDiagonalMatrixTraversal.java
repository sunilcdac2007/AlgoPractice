package com.interview.feb12;

public class LeftUpDiagonalMatrixTraversal {

    public static void main(String[] args) {
    int[][] mat= {{1, 2,  3 , 4},
                   {5,  6,  7,  8},
                   {9,  10,  11,  12},
                   {13, 14, 15, 16}};
    /*

1
5 2
9 6 3
13 10 7 4
14 11 8
15 12
16
     */
        matrixTraversal(mat);
    }

     public static void matrixTraversal(int[][] mat){

        for(int row = 0; row < mat.length; row++){

            int start = row;
            int end=0;
            while(start>=0 && end <= row){
                System.out.print(mat[start--][end++] +" ");
            }
            System.out.println();
        }
        for(int col = 1;col < mat.length; col++){
           int start = mat.length-1;
           int end = col;
           while(start>=0 && end < mat.length){
               System.out.print(mat[start--][end++] +" ");
           }
            System.out.println();
        }

     }


}
