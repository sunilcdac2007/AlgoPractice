package com.interview.feb16;

import java.util.*;

public class ChunkMergeArray {

    public static void main(String[] args) {
        int[] a1 = {1, 5, 6, 9,21};
        int[] a2 = {4, 6, 11, 14};
        int a3[] = {-1, 0, 7};
        List<List<Integer>> lst = new ArrayList<>();
        lst.add(Arrays.asList(1, 5, 6, 9,21));
        lst.add(Arrays.asList(4, 6, 11, 14));
        lst.add(Arrays.asList(-1, 0, 7));
        List<Integer> sortedList = chunkMerge(lst);
        sortedList.forEach(System.out::print);

    }

    static class Bean{
        int data;
        int elementIndex;
        int arrayIndex;
        Bean(int data, int elementIndex, int arrayIndex){
            this.data = data;
            this.elementIndex = elementIndex;
            this.arrayIndex = arrayIndex;
        }
    }
    public static List<Integer> chunkMerge(List<List<Integer>> listOfSortedArray){

        PriorityQueue<Bean> queue = new PriorityQueue<>( (Bean b1, Bean b2) -> {

            if(b1.data < b2.data){
                return -1;
            } else if(b1.data == b2.data){
                return 0;
            } else {
                return +1;
            }
        });
        List<Integer> result = new ArrayList<>();
        for(int index=0; index< listOfSortedArray.size(); index++){
            queue.add(new Bean(listOfSortedArray.get(index).get(0), 0, index));
        }
        while(!queue.isEmpty()){
        Bean b = queue.poll();
        result.add(b.data);
        if(b.elementIndex + 1 < listOfSortedArray.get(b.arrayIndex).size()){
            Bean b1 = new Bean(listOfSortedArray.get(b.arrayIndex).get(b.elementIndex+1), b.elementIndex+1, b.arrayIndex);
            queue.offer(b1);
        }
        }
        return result;
    }
}

