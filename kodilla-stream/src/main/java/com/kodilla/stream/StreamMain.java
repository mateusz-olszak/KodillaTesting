package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;

public class StreamMain {

    public static void main(String[] args) {
//
//        String text = "This is my examplary sentence.";
//        String decoratedText1 = text.toUpperCase().replaceAll("[E ]","*").split("X")[0];
//        String decoratedText2 = text.toUpperCase().replaceAll("[E ]","*").split("X")[1];
//
//        PoemBeautifier.beautify(text, decorator -> "ABC | " + decoratedText1 + " | ABC" + "!!!");
//        PoemBeautifier.beautify(text, decorator -> "ABC | " + decoratedText2 + " | ABC" + "!!!");

        NumbersGenerator.generateEven(20);

    }

}
