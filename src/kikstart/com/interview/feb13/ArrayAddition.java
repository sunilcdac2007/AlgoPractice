package com.interview.feb13;

public class ArrayAddition {
    public static void main(String[] args) {
     int[] arr1 = {9,9,9,9,9,9,9};
     int[] arr2 = {1,9,6,7,9,9,9};
        //int[] arr1 = {1,9,9};
        //int[] arr2 = {9,9};
     int[] arr3 =  addArray(arr1, arr2);
     for(int num: arr3){
         System.out.print(num+" ");
     }
    }

    public static int[] addArray(int[] arr1, int[] arr2){
     int len = Math.max(arr1.length, arr2.length);
     int[] out = new int[len];
     int index = out.length-1;
     int carry=0;
     int remainder = 0;
        int i=arr1.length-1;
        int j = arr2.length-1;
     for(; i >=0 && j>=0; i--, j--){
         int temp = arr1[i] + arr2[j]+ carry;
         carry = temp/10;
         out[index--]= temp%10;
     }
     while(i >=0){
         int temp = arr1[i--] + carry;
         carry = temp/10;
         out[index--] = temp%10;
     }

     while(j >=0){
         int temp = arr2[j--] + carry;
         carry = temp/10;
         out[index--] = temp%10;
     }
     if(carry != 0){
         int[] out1 = new int[out.length+1];
         for(int i1=out1.length-1; i1>0; i1--){
             out1[i1] = out[i1-1];
         }
         out1[0] = carry;
         return out1;
     }

     return out;
    }
}
