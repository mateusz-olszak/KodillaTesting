package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {

    public List<Integer> exterminate(List<Integer> numbers){
        List<Integer> evenNumbers = new ArrayList<>();
        for(Integer x : numbers){
            if (x % 2 == 0)
                evenNumbers.add(x);
        }
        return evenNumbers;
    }

}
