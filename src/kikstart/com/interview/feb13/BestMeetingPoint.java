package com.interview.feb13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestMeetingPoint {
    public static void main(String[] args) {
        int[][] dist = {{1,0,0,0,1},
                        {0,0,0,0,0},
                        {0,0,1,0,0}};
       // System.out.println(minDistanceMeetingPoint(dist));
        int grid[][] = {{1, 0, 1, 0, 1},
                        {0, 1, 0, 0, 0},
                        {0, 1, 1, 0, 0}};
        System.out.println(minDistanceMeetingPoint(grid));
    }

    public static int minDistanceMeetingPoint(int[][] distanct){
        List<Integer> horizantal = new ArrayList<>();
        List<Integer> vertical = new ArrayList<>();
        for(int i=0; i < distanct.length; i++){
            for (int j=0; j< distanct[0].length; j++){
                if(distanct[i][j] == 1){
                    vertical.add(i);
                    horizantal.add(j);
                }
            }
        }
        Collections.sort(horizantal);
        Collections.sort(vertical);
       int dist =0;
       int size = vertical.size()/2;
       int x = horizantal.get(size);
       int y = vertical.get(size);
       for(int i=0; i < distanct.length; i++){
           for(int j=0; j < distanct[0].length; j++){
               if(distanct[i][j] == 1){
                   dist += Math.abs(x-i)+ Math.abs(y-j);
               }
           }
       }
        return dist;
    }


}
