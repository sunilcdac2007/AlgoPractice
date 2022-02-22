package com.interview.feb14;

import java.util.ArrayList;
import java.util.List;

public class CountSamallerOnRight {
    public static void main(String[] args) {
        CountSamallerOnRight c = new CountSamallerOnRight();
        int[] input= {5,2,6,1,0,13};
        List<Integer> lst = c.countSamaller(input);
        lst.forEach(System.out::println);
        System.out.println("end program");

    }

    public ArrayList<Integer> countSamaller(int arr[]){
    int len=arr.length;
    Item[] items = new Item[len];
    for(int i=0; i< len; i++){
        items[i] = new Item(i, arr[i]);
    }
    int[] count = new int[len];
    mergeUtil(items, count, 0, len-1);
    ArrayList<Integer> lst = new ArrayList<>();
    for(int num: count){
        lst.add(num);
    }
    return lst;
    }

    private void mergeUtil(Item[] items, int[] count, int low, int high) {

        if(low > high){
            return;
        }
        int mid = (low+high)/2;
        mergeUtil(items, count, low, mid-1);
        mergeUtil(items, count, mid+1, high);
        merg(items, count, low, mid, mid+1, high);
    }

    private void merg(Item[] items, int[] count, int low, int lowEnd, int high, int highEnd) {
    int localLen = highEnd-low+1;
    Item[] sortedItem =new Item[localLen];
    int rightCounter=0;
    int lowPtr=low, highPtr = high;
    int index=0;

    while(lowPtr <= lowEnd && highPtr <= highEnd){

        if(items[lowPtr].value > items[highPtr].value){
            rightCounter++;
            sortedItem[index++] = items[highPtr++];
        } else {
            count[items[lowPtr].index] += rightCounter;
            sortedItem[index++] = items[lowPtr++];
        }
    }

    while(lowPtr <=lowEnd){
        count[items[lowPtr].index] += rightCounter;
        sortedItem[index++] = items[lowPtr++];
    }
    while(highPtr <=highEnd){
        sortedItem[index++]=items[highPtr++];
    }
    System.arraycopy(sortedItem, 0, items, low, localLen);
    }

    class Item{
        int index;
        int value;
        Item(int index, int value){
            this.index=index;
            this.value=value;
        }
    }


}
