package com.javastreamslp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NumberPlayList {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<Integer>();
        for(int i = 0; i < 5 ; i++) {
            myList.add(i);
        }

        // Processing Stream
        myList.stream().forEach(n ->{
            System.out.println(" Stream For Each Value::"+n);
        });

        //Double Function
        Function<Integer,Double> toDoubleFunction = Integer::doubleValue;
        List<Double> doubleList = myList.stream().map(toDoubleFunction).collect(Collectors.toList());
        System.out.println("Double List is: " + doubleList);

        //Filter Even Numbers
        Predicate<Integer> isEvenFunction = n -> n > 0 && n % 2 == 0;

        List<Integer> evenList = myList.stream().filter(isEvenFunction).collect(Collectors.toList());
        System.out.println("Even Numbers List : " + evenList);

        Integer first = myList.stream().filter(isEvenFunction)
                              .peek(n -> System.out.println("Peak Even Number : " +n))
                              .findFirst()
                              .orElse(null);
        System.out.println("First Even Number is: " + first);

        //Min Even Number
        Integer min = myList.stream().filter(isEvenFunction)
                                     .min(Comparator.comparing(Integer::intValue))
                                     .orElse(null);
        System.out.println("Min Even Number: " +min);

        //Max Even Number
        Integer max = myList.stream().filter(isEvenFunction)
                                     .max(Comparator.comparing(Integer::intValue))
                                     .orElse(null);
        System.out.println("Max Even Number: " +max);
    }
}
