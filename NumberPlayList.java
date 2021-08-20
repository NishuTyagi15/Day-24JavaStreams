package com.javastreamslp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumberPlayList {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<Integer>();
        for(int i = 0; i < 4 ; i++) {
            myList.add(i);
        }

        // Processing Stream
        myList.stream().forEach(n ->{
            System.out.println(" Stream For Each Value ::" +n);
        });


        Function<Integer,Double> toDoubleFunction = Integer::doubleValue;
        List<Double> doubleList = myList.stream().map(toDoubleFunction).collect(Collectors.toList());
        System.out.println("Double List is: " + doubleList);
    }
}
