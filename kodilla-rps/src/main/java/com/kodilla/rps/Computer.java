package com.kodilla.rps;

import java.util.Random;

public class Computer extends GameState {

    private final String name = "aiComputer";

    public CHOICES getChoice(){
        Random random = new Random();
        int choice = random.nextInt(5)+1;

        switch (choice){
            case 1:
                return CHOICES.ROCK;
            case 2:
                return CHOICES.PAPER;
            case 3:
                return CHOICES.SCISSORS;
            case 4:
                return CHOICES.SPOCK;
        }
        return CHOICES.LIZARD;
    }

}
