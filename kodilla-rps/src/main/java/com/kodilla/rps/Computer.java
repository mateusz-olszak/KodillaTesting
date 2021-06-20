package com.kodilla.rps;

import java.util.Random;

public class Computer extends GameState {

    private final CHOICES figure;

    public Computer(final User user) {
        this.figure = user.getFigure();
    }

    private CHOICES getComputerChoice(){
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
            case 5:
                return CHOICES.LIZARD;
        }
        return null;
    }

    public CHOICES getChoice(){
        if (figure == getComputerChoice()){
            return getComputerChoice();
        }
        else if (figure == CHOICES.ROCK && getComputerChoice() == CHOICES.SPOCK || figure == CHOICES.ROCK && getComputerChoice() == CHOICES.PAPER)
            return getComputerChoice();
        else if (figure == CHOICES.PAPER && getComputerChoice() == CHOICES.LIZARD || figure == CHOICES.PAPER && getComputerChoice() == CHOICES.SCISSORS)
            return getComputerChoice();
        else if (figure == CHOICES.SCISSORS && getComputerChoice() == CHOICES.ROCK || figure == CHOICES.SCISSORS && getComputerChoice() == CHOICES.SPOCK)
            return getComputerChoice();
        else if (figure == CHOICES.SPOCK && getComputerChoice() == CHOICES.PAPER || figure == CHOICES.SPOCK && getComputerChoice() == CHOICES.LIZARD)
            return getComputerChoice();
        else if (figure == CHOICES.LIZARD && getComputerChoice() == CHOICES.ROCK || figure == CHOICES.LIZARD && getComputerChoice() == CHOICES.SCISSORS)
            return getComputerChoice();
        else
            return getComputerChoice();
    }
}
