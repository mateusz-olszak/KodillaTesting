package com.kodilla.rps;

import java.util.Scanner;

public class User{

    private String username;
    private Choice figure;

    public User(final String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public Choice getChoice(){
        Scanner input = new Scanner(System.in);
        System.out.print("Choose your figure:\n[1] ROCK | [2] PAPER | [3] SCISSORS | [4] SPOCK | [5] LIZARD" +
                "\n[x] END GAME | [n] RESTART GAME: ");
        char choice = input.nextLine().toUpperCase().charAt(0);
        switch (choice){
            case '1':
                figure = Choice.ROCK;
                return Choice.ROCK;
            case '2':
                figure = Choice.PAPER;
                return Choice.PAPER;
            case '3':
                figure = Choice.SCISSORS;
                return Choice.SCISSORS;
            case '4':
                figure = Choice.SPOCK;
                return Choice.SPOCK;
            case '5':
                figure = Choice.LIZARD;
                return Choice.LIZARD;
            case 'X':
                System.out.print("Are you sure you want to end the game ? [y] yes | [n] no: ");
                choice = input.nextLine().charAt(0);
                if (choice == 'y') return Choice.END;
                break;
            case 'N':
                System.out.print("Are you sure you want to restart the game ? [y] yes | [n] no: ");
                choice = input.nextLine().charAt(0);
                if (choice == 'y') return Choice.RESTART;
                break;
        }

        return getChoice();
    }

    public Choice getFigure(){
        return figure;
    }
}
