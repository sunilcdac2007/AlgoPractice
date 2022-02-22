package com.interview.feb21;

public class MaxFruit {

    public static void main(String[] args) {
        long arr[] = { 2 ,1 ,3 ,5 ,0 ,1 ,4};
        long arr1[] ={1, 6, 2, 5, 3, 4 };
        long arr2[] = {246, 608, 2285, 396, 1722, 2346, 277, 2061, 1337, 2959, 2449, 240, 633, 1822, 2676};
        int n =7;
        int m=3;
        // output = 9;
        //long l = maxFruits(arr, n, m);
        // long l = maxFruits(arr1, 6, 2);
        long l = maxFruits(arr2, 15, 12);
        System.out.println(l);

    }

    public static long maxFruits(long arr[] ,int n,int m)
    {
        long maxFruit= Integer.MIN_VALUE;
        long maxLocalFruit = 0;
        int startIndex =0;
        int i=0;
        for(;  i < n ; i++){
            if( (i-startIndex) == m){
                System.out.println(maxLocalFruit);
                i = startIndex;
                startIndex = i +1;
                maxLocalFruit = 0;
                continue;
            }
            maxLocalFruit = maxLocalFruit + arr[i];

            if(maxLocalFruit > maxFruit){
                maxFruit = maxLocalFruit;
            }
        }
        return maxFruit;

    }
}
