package com.interview.feb13;

public class CheckIfArrayElementConsecutive {
    public static void main(String[] args) {
        int[] arr = {76,78,75,77,73,74};

        int[] arr1 = {76,78,75,77,73,74, 79,88};
        boolean is =isConsecutiveArray(arr);
        System.out.println(is);
        is =isConsecutiveArray(arr1);
        System.out.println(is);
    }

    public static boolean isConsecutiveArray(int[] arr){
        if(arr.length == 0){
            return false;
        }
        int min= Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num: arr){
            if(num > max){
                max = num;
            }
            if(num < min){
                min= num;
            }
        }
        if(Math.abs(max-min) > arr.length){
            return false;
        }

        for(int num: arr){
            if(num - min < 0 || max-num > arr.length){
                return false;
            }
        }
        return true;
    }
}
