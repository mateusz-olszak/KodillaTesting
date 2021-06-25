package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import com.kodilla.exception.io.FileReaderWithoutHandling;
import com.kodilla.exception.test.FirstChallenge;
import com.kodilla.exception.test.Flight;
import com.kodilla.exception.test.FlightFinder;
import com.kodilla.exception.test.RouteNotFoundException;

import java.io.IOException;

public class ExceptionModuleRunner {
    public static void main(String[] args){
//        taskModule8_3();

        ///// task module 8.4:
        Flight flight = new Flight("Warsaw Airport", "Belgium Airport");
        FlightFinder flightFinder = new FlightFinder();

        try {
            System.out.println(flightFinder.findFlight(flight));
        }catch (RouteNotFoundException e){
            System.out.println("This airport is unreachable. " + e.getMessage());
        }

//        FileReader fileReader = new FileReader();
//
//        try {
////            fileReader.readFile();
//        }catch (FileReaderException e){
//            System.out.println("Problem while reading a file!" + e);
//        }

    }

    private static void taskModule8_3(){
        FirstChallenge challenge = new FirstChallenge();

        try {
            double result = challenge.divide(3, 0);
            System.out.println(result);
        }catch (ArithmeticException e){
            System.out.println("Do not divide by zero. " + e);
        }finally {
            System.out.println("Calucaltion has been completed");
        }
    }

}
