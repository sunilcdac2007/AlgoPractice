package com.interview.feb12;

import java.math.BigInteger;

public class AdditiveNumber {
    // 123581321 -- additive number
    public static void main(String[] args) {
        System.out.println("program on 12th Feb 2022");
        System.out.println(isAdditiveNumber("123581321"));
        System.out.println(isAdditiveNumber("132134"));
        System.out.println(isAdditiveNumber("6666666677"));
    }

    public static boolean isAdditiveNumber(String num){

        if(num.length() < 3){
            return false;
        }

        for(int idx=0; idx < num.length()/2; idx++ ){
            if(num.startsWith("0") && idx > 0){
                break;
            }
            BigInteger num1 = new BigInteger(num.substring(0, idx+1));
            for(int jdx=idx+1; Math.max(idx, (jdx-1)) +1 < num.length() - jdx-1; jdx++){
                if(num.charAt(jdx) == '0' && jdx > idx+1){
                    break;
                }
                BigInteger num2 = new BigInteger(num.substring(idx+1, jdx+1));
                if(isValidAdditive(num1, num2, num, jdx+1)){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isValidAdditive(BigInteger x1, BigInteger x2, String num, int index){
        if(index == num.length()){
            return true;
        }
        BigInteger x3 = x1.add(x2);
        return num.startsWith(x3.toString(), index) && isValidAdditive(x2,x3,num, index + x3.toString().length());
    }

}
