package com.interview.feb20;

/*
how to print the maximum number of a using giving four keys.
Imagin you have a special keyword with the following key
key1: - print A
key2: ctr+A
key3: ctr+c
key4: ctr+v
if you can only press the keyword for N times with the help of above four key then produce maximum number of A'S
 */
public class CountAs {

    public int countAsRec(int n){
        if(n < 7){
            return n;
        }
        int max = Integer.MIN_VALUE;
        int result =0;
        for(int b=n-3; b>0; b--){
            result = (n-b-1) * countAsRec(b);
            if(max < result){
                max = result;
            }
        }
        return max;
    }
}
