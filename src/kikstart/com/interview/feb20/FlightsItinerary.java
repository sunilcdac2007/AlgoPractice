package com.interview.feb20;

import com.sun.source.doctree.InlineTagTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*

Given an unordered list of flights taken by someone, each represented as (origin, destination) pairs, and a starting airport, compute the person's itinerary. If no such itinerary exists, return undefined. All flights must be used in the itinerary.

For example, given the list of flights [['SFO', 'HKO'], ['YYZ', 'SFO'], ['YUL', 'YYZ'], ['HKO', 'ORD']] and starting airport 'YUL', you should return the list ['YUL', 'YYZ', 'SFO', 'HKO', 'ORD'].

Given the list of flights [['SFO', 'COM'], ['COM', 'YYZ']] and starting airport 'COM', you should return undefined.

let breakingTestCase = [['A', 'E'], ['B', 'C'], ['C', 'D'], ['D', 'A'], ['A', 'B']]
let startPoint = 'A';
 */
public class FlightsItinerary {

    public static void main(String[] args) {
String[][] flights = {{"SFO", "HKO"}, {"YYZ", "SFO"}, {"YUL", "YYZ"}, {"HKO", "ORD"}};
//String[][] flights1= {{"SFO", "COM"}, {"COM", "YYZ"}};
//String[][] flights3 = {{"A", "E"}, {"B", "C"}, {"C", "D"}, {"D", "A"}, {"A", "B"}};
    List<String> cains = findIteneray(flights, "YUL");
  //  List<String> cains = findIteneray(flights1, "COM");
   // List<String> cains = findIteneray(flights3, "A");
    cains.forEach(System.out::println);
    }

    public static List<String> findIteneray(String[][] flights, String start){
   List<Itinearray> input = new ArrayList<>();
   for(String[] flight: flights){
       input.add(new Itinearray(flight[0], flight[1]));
   }

        Collections.sort(input);
   List<String> output = new ArrayList<>();
   boolean[] used = new boolean[input.size()];
    findItenerarryUtil(input, used, start, output, 0);
  return output;
    }

    public static boolean findItenerarryUtil(List<Itinearray> input, boolean[] used, String dest, List<String> output, int count){

        if(count == used.length){
            output.add(dest);
            return true;
        }

        for(int i=0; i < input.size(); i++){
            if(used[i]){
                continue;
            }

            Itinearray itr = input.get(i);
            if(itr.source.equalsIgnoreCase(dest)){
                output.add(itr.source);
                used[i]= true;
                if(findItenerarryUtil(input, used, itr.dist, output, count+1)){
                    return true;
                }
                used[i] = false;
                output.remove(output.size()-1);

            }
        }

        return false;

    }


    static class Itinearray implements Comparable<Itinearray>{

        String source;
        String dist;

        Itinearray(String source, String dist){
            this.source = source;
            this.dist = dist;
        }
        @Override
        public int compareTo(Itinearray o) {
            if(this.source.equalsIgnoreCase(o.source)){
                return this.dist.compareTo(o.dist);
            } else {
                return this.source.compareTo(o.source);
            }
        }
    }
}
