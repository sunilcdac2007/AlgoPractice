package com.interview.feb13;

import java.util.LinkedList;
import java.util.Stack;

public class EvaluateExpression {
    public static void main(String[] args) {
    // 10*9/7+6-5*4/3+2*1

        // 10*9/8+7-6*5/4+3-2*1
        //System.out.println(90/7);
        System.out.println(evaluateExp("10*9/7+6-5*4/3+2*1"));
        System.out.println(evaluateExp("10*9/8+7-6*5/4+3-2*1"));
    }

    public static int evaluateExp(String exp){
        char[] token = exp.toCharArray();
        Stack<Character> operator = new Stack<Character>();
        Stack<Integer> values = new Stack<>();
        int len = exp.length()-1;
        for(int i=0; i <= len; i++){
         if(token[i] == ' '){
             continue;
         }
         if(token[i] >= '0' && token[i] <= '9'){
             StringBuilder buff = new StringBuilder();

             while(i < token.length && token[i] >= '0' && token[i] <= '9'){
                 buff.append(token[i++]);
             }
            values.push(Integer.parseInt(buff.toString()));
            i--;
         } else {
             char currOperator = token[i];
             if(!operator.isEmpty()){
                 char prevOperator = operator.peek();
                 if(isHigherPresedence(prevOperator, currOperator)){
                     int val1 = values.pop();
                     int val2 = values.pop();
                     //System.out.println(val1 +" "+ val2);
                     values.push(evaluate(val2, val1, operator.pop()));
                 }
             }
                 operator.push(currOperator);
         }
        }
      /*  while(!values.empty()){
            System.out.print(values.pop()+" ");
        } */
        System.out.println();
        while(!operator.empty()){
            int val1 = values.pop();
            int val2 = values.pop();
           // System.out.println(val1 +" "+ val2);
            values.push(evaluate(val2, val1, operator.pop()));
        }
        System.out.println(values.size());
        return values.pop();
    }

    private static int evaluate(Integer value1, Integer value2, Character operator) {
        switch(operator){
            case '*':
                return value1 * value2;
            case '/':
                return (int)Math.ceil(value1 / value2);
            case '+':
                return value1 + value2;
            case '-':
                return value1 - value2;
            default:
                System.out.println("test");
                return 0;
        }

    }

    private static boolean isHigherPresedence(char prevOperator, char currOperator) {
        //
        boolean flag = false;

        if(prevOperator == '*'){
            flag = true;
        } else if(prevOperator == '/' && (currOperator== '+' || currOperator== '-' )){
            flag = true;
        } else if (currOperator== '+'  && currOperator== '-' ){
            flag = true;
        }
        return flag;
    }

}
