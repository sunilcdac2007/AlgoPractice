package com.interview.feb14;

import java.util.Arrays;

public class CountSmaller {
    public static void main(String[] args) {
        int[] arr= {5,2,6,1,0,13};
        // 3 2 2 1 0 0
        int[] result = new int[arr.length];
        count(arr,result);

        Arrays.stream(result).forEach(System.out::println);
    }

    private static void count(int[] arr, int[] result) {

        for(int i=0; i< arr.length; i++){
            for(int j=i+1; j< arr.length; j++){
                if(arr[j] < arr[i]){
                    result[i]++;
                }
            }
        }
    }


}
