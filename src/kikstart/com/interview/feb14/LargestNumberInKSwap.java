package com.interview.feb14;

public class LargestNumberInKSwap {
    public static void main(String[] args) {
        findMaximumNum("346765321234", 3);
    }

    //Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k)
    {
        //code here.
        Result res = new Result();
        res.max = str;
        findMaxNum(str.toCharArray(), k, res);
        return res.max;
    }

    public static void findMaxNum(char[] arr, int k, Result res){

        if(k==0 ){
            return ;
        }
        int n = arr.length;
        for(int i=0; i < n-1; i++){
            for(int j=i+1; j <n ; j++){
                if(arr[j] > arr[i]){
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    String st = new String(arr);
                    if(res.max.compareTo(st)< 0){
                        res.max = st;
                    }
                    findMaxNum(arr, k-1, res);
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j]= temp;
                }
            }
        }
    }

    static class Result{
        static String max="";
    }
}
