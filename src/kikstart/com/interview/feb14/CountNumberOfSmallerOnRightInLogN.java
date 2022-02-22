package com.interview.feb14;

import java.util.Arrays;

public class CountNumberOfSmallerOnRightInLogN {
    public static void main(String[] args) {
        int[] input= {5,2,6,1,0,13};
        // 3 2 2 1 0 0
        int[] result = findSmallerElementOnRight(input);
        Arrays.stream(result).forEach(System.out::println);
    }

    private static int[] findSmallerElementOnRight(int[] input) {
        if(input.length == 0){
            return null;
        }
       Index[] arr = new Index[input.length];
       for(int i=0; i< input.length; i++){
           arr[i] = new Index(i, input[i]);
       }
       int[] result = new int[input.length];
       mergeUtil(arr, result, 0, input.length -1);
       return result;
    }

    private static void mergeUtil(Index[] arr, int[] result, int low, int high ){

        if(low >= high){
            return ;
        }

        int mid = (low+ high)/2;
        mergeUtil(arr, result, low,mid-1);
        mergeUtil(arr, result, mid+1, high);
        int i=low;
        int j = mid+1;
        int tResult[] = new int[high-low+1];
        Index[] tIndex = new Index[high-low+1];
        int k=0;
        while(i <=mid && j<= high){
            if(arr[i].value <= arr[j].value){
                tResult[arr[i].index -low] = j-mid -1;
                tIndex[k++]= arr[i++];
            } else {
                tResult[arr[i].index - low] = j-mid;
                tIndex[k++] = arr[j++];
            }
        }
        int i1 = i;
        while(i1 <= mid){
            tResult[arr[i1].index - low] = j-mid-1;
            tIndex[k++] = arr[i1++];
        }

        while(k < tIndex.length && j <= high && i1 < arr.length){
            tResult[arr[i1].index - low] = j-mid-1;
            tIndex[k++] = arr[i1++];
        }
        System.out.println("value of k in first iteration "+k);
        k=0;
        for(i=low; i <= high; i++){
            arr[i] = tIndex[k];
            result[i] += tResult[k++];
        }
    }
    static class Index{
        int index;
        int value;
        Index(int index, int value){
            this.index = index;
            this.value = value;
        }
    }

}
