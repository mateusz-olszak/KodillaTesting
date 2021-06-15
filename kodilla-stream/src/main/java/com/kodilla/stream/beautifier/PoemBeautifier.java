package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public static void beautify(String textToDecorate, PoemDecorator decorator){
        String resultText = decorator.decorate(textToDecorate);
        System.out.println(resultText);
    }

}
