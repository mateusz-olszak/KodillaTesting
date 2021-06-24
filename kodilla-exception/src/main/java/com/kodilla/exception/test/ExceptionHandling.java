package com.kodilla.exception.test;

public class ExceptionHandling {

    public void handleMethod(double x, double y) {
        SecondChallenge challenge = new SecondChallenge();

        try {
            challenge.probablyIWillThrowException(x,y);
        }catch (Exception e){
            throw new IllegalArgumentException();
        }finally {
            System.out.println("Iam always here");
        }
    }

}
