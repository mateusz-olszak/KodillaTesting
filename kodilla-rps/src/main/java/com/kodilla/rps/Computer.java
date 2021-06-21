package com.kodilla.rps;

import java.util.Random;

public class Computer {

    private final Choice figure;

    public Computer(final User user) {
        this.figure = user.getFigure();
    }

    private Choice getComputerChoice(){
        Random random = new Random();
        int choice = random.nextInt(5)+1;

        switch (choice){
            case 1:
                return Choice.ROCK;
            case 2:
                return Choice.PAPER;
            case 3:
                return Choice.SCISSORS;
            case 4:
                return Choice.SPOCK;
            case 5:
                return Choice.LIZARD;
        }
        return null;
    }

    public Choice getChoice(){
        if (figure == getComputerChoice()){
            return getComputerChoice();
        }
        else if (figure == Choice.ROCK && getComputerChoice() == Choice.SPOCK || figure == Choice.ROCK && getComputerChoice() == Choice.PAPER)
            return getComputerChoice();
        else if (figure == Choice.PAPER && getComputerChoice() == Choice.LIZARD || figure == Choice.PAPER && getComputerChoice() == Choice.SCISSORS)
            return getComputerChoice();
        else if (figure == Choice.SCISSORS && getComputerChoice() == Choice.ROCK || figure == Choice.SCISSORS && getComputerChoice() == Choice.SPOCK)
            return getComputerChoice();
        else if (figure == Choice.SPOCK && getComputerChoice() == Choice.PAPER || figure == Choice.SPOCK && getComputerChoice() == Choice.LIZARD)
            return getComputerChoice();
        else if (figure == Choice.LIZARD && getComputerChoice() == Choice.ROCK || figure == Choice.LIZARD && getComputerChoice() == Choice.SCISSORS)
            return getComputerChoice();
        else
            return getComputerChoice();
    }
}
